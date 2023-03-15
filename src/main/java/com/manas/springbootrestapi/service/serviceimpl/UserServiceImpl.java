package com.manas.springbootrestapi.service.serviceimpl;

import com.manas.springbootrestapi.entity.User;
import com.manas.springbootrestapi.repository.UserRepository;
import com.manas.springbootrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        try {
            return userRepository.save(user);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User deleteUserById(Long userId) {
        User user = userRepository.findById(userId).get();
        userRepository.delete(user);
        return user;
    }

    @Override
    public User updateUser(Long userId, User user) {
//        User user1 = userRepository.findById(userId).get();
//        user1.setName(user.getName());
//        user1.setAge(user.getAge());
//        user1.setEmail(user.getEmail());

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }
}
