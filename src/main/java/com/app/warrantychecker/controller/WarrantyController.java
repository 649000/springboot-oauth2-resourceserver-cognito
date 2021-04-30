package com.app.warrantychecker.controller;

import com.app.warrantychecker.model.User;
import com.app.warrantychecker.model.Warranty;
import com.app.warrantychecker.repository.WarrantyRepository;
import com.app.warrantychecker.service.WarrantyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

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
        Optional<Warranty> warranty = warrantyService.findOne(id);
        if (warranty.isPresent()){
            return warranty.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @GetMapping
    public Iterable<Warranty> findAll() {
        logger.info("WarrantyController::findAll");
        return warrantyService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Warranty create(@RequestBody @Validated Warranty warranty){
        logger.info("WarrantyController::create");
        return warrantyService.save(warranty);
    }

    @PatchMapping("/{id}")
    public Warranty update( @PathVariable("id") long id, @RequestBody Warranty warranty){
        logger.info("WarrantyController::update()");

        Optional<Warranty> optionalWarranty = warrantyService.findOne(id);

        if (optionalWarranty.isPresent()){

            optionalWarranty.get().setProductBrand(warranty.getProductBrand());
            optionalWarranty.get().setProductName(warranty.getProductName());
            optionalWarranty.get().setProductSerialNumber(warranty.getProductSerialNumber());
            optionalWarranty.get().setDateOfPurchase(warranty.getDateOfPurchase());
            optionalWarranty.get().setEndDate(warranty.getEndDate());
            optionalWarranty.get().setPlaceOfPurchase(warranty.getPlaceOfPurchase());

            return warrantyService.save(optionalWarranty.get());
        } else {
            throw new EntityNotFoundException();
        }

    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        logger.info("WarrantyController::delete()");
        warrantyService.delete(id);
    }

}
