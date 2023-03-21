package com.manas.service;

import com.manas.dto.reponse.SimpleResponse;
import com.manas.dto.request.CarRequest;

public interface CarService {

    SimpleResponse saveCar(CarRequest carRequest);

//    List<User> getAllUsers();
//    User deleteUserById(Long userId);
//    User updateUser(Long userId, User user);
//    User getUserById(Long userId);
}
