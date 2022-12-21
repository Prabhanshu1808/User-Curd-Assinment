package com.userProfile.controller;

import com.userProfile.model.User;
import com.userProfile.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Create User
    @PostMapping("/")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User createUser = userService.createUser(user);
        return new ResponseEntity<User>(createUser , HttpStatus.CREATED);
    }

    //Get Single user
    @GetMapping("/{Id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer Id){
        User findUser =  userService.getUserById(Id);
        return new ResponseEntity<User>(findUser , HttpStatus.FOUND);
    }

    //Update user by Id
    @PutMapping("/{Id}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user , @PathVariable Integer Id){
          return new ResponseEntity<User>(userService.updateUser(user , Id) , HttpStatus.OK);
    }

    //Delete User
    @DeleteMapping("/{Id}")
    public String deleteUser(@PathVariable Integer Id){
        userService.deleteUser(Id);
        return "User is deleted";
    }

    //Get All User
    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}
