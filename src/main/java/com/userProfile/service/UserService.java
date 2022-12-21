package com.userProfile.service;

import com.userProfile.exception.ResourceNotFoundException;
import com.userProfile.model.User;
import com.userProfile.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public User createUser(User user){
        return userRepo.save(user);
    }

    public User getUserById(Integer id){
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User" , "id" , id));
    }

    public User updateUser(User user , Integer id){
        User findUser = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id", id));

        findUser.setName(user.getName());
        findUser.setAddress(user.getAddress());
        findUser.setPin_code(user.getPin_code());
        findUser.setState(user.getState());
        return userRepo.save(findUser);
    }

    public void deleteUser(Integer id){
        User findUser = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id" , id));
        userRepo.delete(findUser);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }



}
