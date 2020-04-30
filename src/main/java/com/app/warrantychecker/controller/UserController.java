//package com.app.warrantychecker.controller;
//
//import com.app.warrantychecker.model.User;
//import com.app.warrantychecker.model.Warranty;
//import com.app.warrantychecker.service.UserService;
//import com.app.warrantychecker.service.WarrantyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.persistence.EntityNotFoundException;
//
//@RestController
//@RequestMapping(path = "/user")
//public class UserController {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    WarrantyService warrantyService;
//
//    @GetMapping("/{email}")
//    public User findOne(@PathVariable String email) throws Exception {
//        if (userService.findOne(email).isPresent()) {
//            return userService.findOne(email).get();
//        } else {
//            throw new EntityNotFoundException("The User does not exist.");
//        }
//    }
//
//    @GetMapping
//    public Iterable<User> findAll() {
//        return userService.findAll();
//    }
//
//    @PostMapping
//    public User create(@RequestBody @Validated User user) {
//        if (userService.findOne(user.getEmail()).isPresent()) {
//            return userService.findOne(user.getEmail()).get();
//        } else {
//            return userService.create(user);
//        }
//    }
//
//    @DeleteMapping("/{email}")
//    public void delete(@PathVariable String email) {
//        userService.delete(email);
//    }
//
//    @GetMapping("/{email}/warranty")
//    public Iterable<Warranty> findAllWarranty(@PathVariable String email) {
//        User user = new User();
//        user.setEmail(email);
//        return warrantyService.findByUser(user);
//    }
//
//}
