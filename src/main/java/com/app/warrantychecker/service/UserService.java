package com.app.warrantychecker.service;

import com.app.warrantychecker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void delete(String email){
        userRepository.deleteById(email);
    }
}
