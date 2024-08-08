package com.j3appdemo.j3_app.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.j3appdemo.j3_app.models.User;
import com.j3appdemo.j3_app.models.dto.UserDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/v2/api")
public class UserRestController {
    @GetMapping("/details")
    public UserDto details(){
        UserDto userDto = new UserDto();
        User user = new User("Oscar", "Arismendi");
        userDto.setTitle("Develop with Spring Boot CreativeCode");
        userDto.setUser(user);
        return userDto;
    }
    @GetMapping("/list-details")
    public List<User> listDetails() {
        User user = new User("Juan", "Camilo");
        User userA = new User("German", "Villalobos");
        User userB = new User("Sebastian", "Valencia");
        // fixed-size list (cannot add/remove elements)
        // List<User> lstUsers = Arrays.asList(user,userA,userB);
        // Resizable list (can add/remove elements)
        List<User> lstUsers = new ArrayList<>(Arrays.asList(user, userA, userB));

        lstUsers.add(user);
        return lstUsers;
    }
    
    // public Map<String, Object> details() {
        
    //     User user = new User("Johlver", "Pardo");

    //     Map<String, Object> body = new HashMap<>();
        
    //     body.put("title", "Develop with Spring Boot CreativeCode");
    //     body.put("author", user);
    //     return body;
    // }

}
