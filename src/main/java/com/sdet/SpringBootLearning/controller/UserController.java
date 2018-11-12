package com.sdet.SpringBootLearning.controller;

import com.sdet.SpringBootLearning.model.User;
import com.sdet.SpringBootLearning.service.UserService;
import com.sdet.SpringBootLearning.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value="/user/{id}", method= RequestMethod.GET)
    public User getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }

    @RequestMapping(value="/users", method= RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
