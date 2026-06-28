package com.example.TestProject.controller;
 
import java.util.List;
 
import org.springframework.web.bind.annotation.*;

import com.example.TestProject.config.AppConfig;
import com.example.TestProject.model.User;
import com.example.TestProject.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@RestController
@RequestMapping("/api/users")
public class UserController {
 
    private final UserService userService;
    private final AppConfig appConfig;
     private static final Logger logger = LoggerFactory.getLogger(UserController.class);
 
    public UserController(UserService userService,AppConfig appConfig) {
        this.userService = userService;
         this.appConfig = appConfig;
    }

    @GetMapping("/configinfo")
    public AppConfig getInfo() 
    {
        return appConfig;
    }
 
     // ✅ GET ALL USERS
    @GetMapping(params = "api-version=1")
    public List<User> getUsers() {
         logger.info("Fetching all users (API v1)");
        return userService.getAllUsers();
    }
 
 
    // ✅ GET ALL USERS
    @GetMapping(params = "api-version=2")
    public List<User> getUsersV2() {
        logger.info("Fetching all users (API v2)");
        return userService.getAllUsersV2();
    }
 
    // ✅ GET USER BY ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
         logger.info("Fetching user with ID: {}", id);
        return userService.getUserById(id);
    }
 
    // ✅ CREATE USER
    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.info("Creating user: {}", user);
        return userService.createUser(user);
        
    }
}