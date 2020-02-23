package com.app.warrantychecker.controller;

import com.app.warrantychecker.model.User;
import com.app.warrantychecker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String HelloWorld(){
        return "Hello World";
    }

    @PostMapping("/")
    public User create(@RequestBody @Validated User user){
        return userService.create(user);
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable String email){
        userService.delete(email);
    }
}
