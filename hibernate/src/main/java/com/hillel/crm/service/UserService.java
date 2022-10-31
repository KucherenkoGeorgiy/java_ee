package com.hillel.crm.service;

import com.hillel.crm.entity.User;
import com.hillel.crm.repository.UserRepository;

import java.util.Optional;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public Optional<User> findByNameAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }
}
