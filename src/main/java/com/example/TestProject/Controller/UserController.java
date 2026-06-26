package com.example.TestProject.Controller;
 
import java.util.List;
 
import org.springframework.web.bind.annotation.*;
 
import com.example.TestProject.Model.User;
import com.example.TestProject.Service.UserService;
 
@RestController
@RequestMapping("/api/users")
public class UserController {
 
    private final UserService userService;
 
    public UserController(UserService userService) {
        this.userService = userService;
    }
 
     // ✅ GET ALL USERS
    @GetMapping(params = "api-version=1")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
 
 
    // ✅ GET ALL USERS
    @GetMapping(params = "api-version=2")
    public List<User> getUsersV2() {
        return userService.getAllUsersV2();
    }
 
    // ✅ GET USER BY ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
 
    // ✅ CREATE USER
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}