package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.User;
import com.example.wheelmanager.domain.repository.AddressRepository;
import com.example.wheelmanager.domain.repository.UserRepository;
import com.example.wheelmanager.domain.service.UserService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getAllUsers(Pageable pageable)
    {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "Id", userId));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User userRequest) {
        return userRepository.findById(userId).map(user -> {
            user.setUserName(userRequest.getUserName())
                    .setPassword(userRequest.getPassword())
                    .setEmail(userRequest.getEmail())
                    .setName(userRequest.getName())
                    .setLastName(userRequest.getLastName())
                    .setImageUrl(userRequest.getImageUrl())
                    .setDni(userRequest.getDni())
                    .setGender(userRequest.getGender())
                    .setBirthDay(userRequest.getBirthDay());
            return userRepository.save(user);
        }).orElseThrow(()->new ResourceNotFoundException("Tag","Id",userId));
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("User" + "Id" + userId));
    }
}
