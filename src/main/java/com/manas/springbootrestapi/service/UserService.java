package com.manas.springbootrestapi.service;

import com.manas.springbootrestapi.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User deleteUserById(Long userId);
    User updateUser(Long userId, User user);
    User getUserById(Long userId);

}
