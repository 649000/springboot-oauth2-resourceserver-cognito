package com.app.warrantychecker.controller;

import com.app.warrantychecker.model.Warranty;
import com.app.warrantychecker.repository.WarrantyRepository;
import com.app.warrantychecker.service.WarrantyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/warranty")
public class WarrantyController {

    Logger logger = LoggerFactory.getLogger(WarrantyController.class);

    @Autowired
    WarrantyService warrantyService;

    @GetMapping("/{id}")
    public Warranty findOne( @PathVariable("id") long id) {
        logger.info("WarrantyController::findOne");
        //Exception Handling
        return warrantyService.findOne(id);
    }

    @GetMapping("/")
    public Iterable<Warranty> findAll() {
        logger.info("WarrantyController::findAll");
        return warrantyService.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Warranty create(@RequestBody @Validated Warranty warranty){
        logger.info("WarrantyController::create");
        return warrantyService.save(warranty);
    }

    @PatchMapping("/{id}")
    public Warranty update( @PathVariable("id") long id, @RequestBody Warranty warranty){
        logger.info("WarrantyController::update()");
        return warrantyService.save(warranty);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        logger.info("WarrantyController::delete()");
        warrantyService.delete(id);
    }

}
