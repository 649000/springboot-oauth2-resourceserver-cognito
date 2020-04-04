package com.app.warrantychecker.service;

import com.app.warrantychecker.model.User;
import com.app.warrantychecker.model.Warranty;
import com.app.warrantychecker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
// It will rollback if there's a SQL exception
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WarrantyService warrantyService;

    public User create(User user){
        return userRepository.save(user);
    }

    public void delete(String email){
        User user = new User();
        user.setEmail(email);
        List<Warranty> warrantyList = warrantyService.findByUser(user);
        warrantyList.forEach(warranty -> {
            warrantyService.delete(warranty.getWarrantyID());
        });
        userRepository.deleteById(email);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findOne(String email){
        return userRepository.findById(email);
    }
}
