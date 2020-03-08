package com.app.warrantychecker.service;

import com.app.warrantychecker.model.User;
import com.app.warrantychecker.model.Warranty;
import com.app.warrantychecker.repository.WarrantyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class WarrantyService {

    @Autowired
    WarrantyRepository warrantyRepository;

    @Autowired
    UserService userService;

    public Warranty findOne(long id){

        return warrantyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("xx"));
    }

    public Iterable<Warranty> findAll(){
        return warrantyRepository.findAll();
    }

    public Warranty save(Warranty warranty){

        Optional<User> user = userService.findOne(warranty.getUser().getEmail());

        if (!user.isPresent()) {
            User newUser = new User();
            newUser.setEmail(warranty.getUser().getEmail());
            userService.create(newUser);
        }
        return warrantyRepository.save(warranty);

    }

    public void delete(long id){
        warrantyRepository.deleteById(id);
    }

    public List<Warranty> findByUser(User user) {
        return warrantyRepository.findByUser(user);
    }
}
