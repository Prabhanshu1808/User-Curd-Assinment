package com.userProfile.repository;

import com.userProfile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User , Integer> {


}
