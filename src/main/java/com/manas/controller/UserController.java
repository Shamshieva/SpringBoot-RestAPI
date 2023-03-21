package com.manas.controller;

import com.manas.dto.reponse.SimpleResponse;
import com.manas.dto.reponse.UserProfile;
import com.manas.dto.request.UserRequest;
import com.manas.entity.User;
import com.manas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;


    @PostMapping
    public SimpleResponse saveUser(@RequestBody UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    @GetMapping("/profile")
    public UserProfile profile(@RequestParam Long userId){
        return userService.getUserProfile(userId);
    }






}
