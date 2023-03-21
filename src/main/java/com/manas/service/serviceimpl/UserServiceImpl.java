package com.manas.service.serviceimpl;

import com.manas.dto.reponse.ResponseCarsPage;
import com.manas.dto.reponse.SimpleResponse;
import com.manas.dto.reponse.UserProfile;
import com.manas.dto.request.UserRequest;
import com.manas.entity.User;
import com.manas.enums.Role;
import com.manas.repository.CarRepository;
import com.manas.repository.UserRepository;
import com.manas.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CarRepository carRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           CarRepository carRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.carRepository = carRepository;
    }

    @PostConstruct
    public void saveAdmin(){
        if (!userRepository.existsByAdmin()) {
            User admin = new User();
            admin.setEmail("burulai@gmail.com");
            admin.setPassword(passwordEncoder.encode("burul"));
            admin.setFirstName("Burulai");
            admin.setLastName("Urbaeva");
            admin.setRole(Role.ADMIN);
            userRepository.save(admin);
        }
    }


    @Override
    public SimpleResponse saveUser(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        userRepository.save(user);
        return new SimpleResponse("SAVE", "User successfully saved!");
    }

//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User deleteUserById(Long userId) {
//        User user = userRepository.findById(userId).get();
//        userRepository.delete(user);
//        return user;
//    }
//
//    @Override
//    public User updateUser(Long userId, User user) {
////        User user1 = userRepository.findById(userId).get();
////        user1.setName(user.getName());
////        user1.setAge(user.getAge());
////        user1.setEmail(user.getEmail());
//
//        return userRepository.save(user);
//    }

//    @Override
//    public User getUserById(Long userId) {
//        return userRepository.findById(userId).get();
//    }

    @Override
    public UserProfile getUserProfile(Long userId) {
        UserProfile userProfile = userRepository.findUserInfo(userId).orElseThrow();

        List<ResponseCarsPage> allUsersCars = carRepository.findAllUserCars(userId);
        userProfile.setCarList(allUsersCars);

        return userProfile;
    }
}
