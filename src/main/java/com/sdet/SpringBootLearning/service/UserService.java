package com.sdet.SpringBootLearning.service;

import com.sdet.SpringBootLearning.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public User getUserById(long id);
}
