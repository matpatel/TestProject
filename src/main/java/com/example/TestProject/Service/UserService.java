package com.example.TestProject.service;
 
import java.util.ArrayList;
import java.util.List;

import com.example.TestProject.exception.ResourceNotFoundException;
import com.example.TestProject.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
 
@Service
public class UserService {
 
    private List<User> users = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
 
    public UserService() {
        // initial data
        users.add(new User(1, "Mathur", "mathur@test.com"));
        users.add(new User(2, "John", "john@test.com"));
    }
 
    // ✅ GET ALL
    public List<User> getAllUsers() {
        return users;
    }
 
    // ✅ GET ALL
    public List<User> getAllUsersV2() {
         users.add(new User(3, "test", "testuser@test.com"));
        return users;
    }
 
    // ✅ GET BY ID
    public User getUserById(int id) {
        logger.debug("Searching for user ID: {}", id);
        var userData = users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);

                if (userData == null)
                    {         
                        logger.warn("User not found for ID: {}", id);
                        throw new ResourceNotFoundException("User not found with id: " + id);
                    }
                return userData;
    }
 
    // ✅ CREATE USER
    public User createUser(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }
}