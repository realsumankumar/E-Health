package com.example.springauthenticateendpoint.controller;

import com.example.springauthenticateendpoint.model.GenericResponse;
import com.example.springauthenticateendpoint.model.User;
import com.example.springauthenticateendpoint.repository.UserRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @RequestMapping("/user-by-id/{id}")
    public GenericResponse getUserById(@PathVariable String id){
        try{
            return new GenericResponse(1, "success", userRepository.findById(id));
        }catch (Exception e){
            e.printStackTrace();
            return new GenericResponse(0, "exception occured" + e.getMessage(), null);
        }
    }

    @RequestMapping("/update-user")
    public GenericResponse updateUserById(@RequestBody User updatedUser){
        try{
            String id = updatedUser.getId();
            User user = userRepository.findById(id).get();
            user = updatedUser;
            userRepository.save(user);
            return new GenericResponse(1,"success", user);
        }catch (Exception e){
            e.printStackTrace();
            return new GenericResponse(0, "exception " + e.getMessage(), null);
        }
    }
}
