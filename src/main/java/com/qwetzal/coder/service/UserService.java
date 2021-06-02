package com.qwetzal.coder.service;

import com.qwetzal.coder.entities.User;
import com.qwetzal.coder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(long id) {
        return userRepository.findById(id).get();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {

        return userRepository.save(user);
    }

    public void deleteUser(long id) {

        User user = userRepository.getOne(id);
        userRepository.delete(user);
    }
}
