package com.app.warrantychecker.controller;

import com.app.warrantychecker.model.Warranty;
import com.app.warrantychecker.repository.WarrantyRepository;
import com.app.warrantychecker.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/warranty")
public class WarrantyController {

    @Autowired
    WarrantyService warrantyService;

    @GetMapping("/{id}")
    public Warranty findOne( @PathVariable("id") long id) {
        //Exception Handling
        return warrantyService.findOne(id);
    }

    @GetMapping("/")
    public Iterable<Warranty> findAll() {
        return warrantyService.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Warranty create(@RequestBody @Validated Warranty warranty){
        return warrantyService.save(warranty);
    }

    @PatchMapping("/{id}")
    public String update( @PathVariable("id") long id, @RequestBody Warranty warranty){
        return "PATCH";
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        warrantyService.delete(id);
    }

}
