package com.app.warrantychecker.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class WarrantyController {

    @GetMapping("/warranty/{id}")
    public String findOne( @PathVariable("id") String id) {
        return "FindOne Foo with id=" + id;
    }

    @GetMapping("/warranty")
    public String findAll() {
        return "findAll";
    }

    @PostMapping("/warranty/2")
    public String create(){
        return "Warranty: Post Mapping";
    }

    @PatchMapping("/warranty/2")
    public String update(){
        return "PATCH";
    }

}
