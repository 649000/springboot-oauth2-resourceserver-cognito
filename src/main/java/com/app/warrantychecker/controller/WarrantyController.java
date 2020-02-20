package com.app.warrantychecker.controller;

import com.app.warrantychecker.model.Warranty;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/warranty")
public class WarrantyController {

    @GetMapping("/{id}")
    public String findOne( @PathVariable("id") String id) {
        return "FindOne Foo with id=" + id;
    }

    @GetMapping("/")
    public String findAll() {
        return "findAll";
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody @Validated Warranty warranty){
        return "Warranty: Post Mapping";
    }

    @PatchMapping("/{id}")
    public String update( @PathVariable("id") String id, @RequestBody Warranty warranty){
        return "PATCH";
    }

}
