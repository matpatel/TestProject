package com.example.TestProject.Service;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.stereotype.Service;
 
import com.example.TestProject.Model.User;
 
@Service
public class UserService {
 
    private List<User> users = new ArrayList<>();
 
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
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
 
    // ✅ CREATE USER
    public User createUser(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }
}