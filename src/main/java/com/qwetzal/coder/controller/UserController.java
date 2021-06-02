package com.qwetzal.coder.controller;

import com.qwetzal.coder.entities.User;
import com.qwetzal.coder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){ return this.userService.getUsers();}

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id){
        return this.userService.getUser(Long.parseLong(id));
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/users/id")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id){
        this.userService.deleteUser(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
