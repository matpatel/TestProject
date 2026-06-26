package com.example.TestProject.Model;

public class User {

    private int id;
    private String name;
    private String email;

    // ✅ No-args constructor (required if already used somewhere)
    public User() {
    }

    // ✅ Add this parameterized constructor (fixes your main error)
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // ✅ Getter
    public int getId() {
        return id;
    }

    // ✅ Setter
    public void setId(int id) {
        this.id = id;
    }

    // Optional but recommended
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
