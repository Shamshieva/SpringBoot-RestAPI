package com.manas.service;

import com.manas.dto.reponse.SimpleResponse;
import com.manas.dto.reponse.UserProfile;
import com.manas.dto.request.UserRequest;

public interface UserService {
    SimpleResponse saveUser(UserRequest userRequest);
//    List<User> getAllUsers();
//    User deleteUserById(Long userId);
//    User updateUser(Long userId, User user);
//    User getUserById(Long userId);

    UserProfile getUserProfile(Long userId);
}
