package com.example.mvc_boot.service;


import com.example.mvc_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void addUser(User user);
    void delete(Long id);
    void updateUser(Long id, User updateUser);
}
