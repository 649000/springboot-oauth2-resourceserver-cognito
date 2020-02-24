package com.app.warrantychecker.service;

import com.app.warrantychecker.model.User;
import com.app.warrantychecker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }

    public void delete(String email){
        userRepository.deleteById(email);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findOne(String email){
        return userRepository.findById(email);
    }
}
