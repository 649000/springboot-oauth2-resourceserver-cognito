package com.app.warrantychecker.service;

import com.app.warrantychecker.model.Warranty;
import com.app.warrantychecker.repository.WarrantyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class WarrantyService {

    @Autowired
    WarrantyRepository warrantyRepository;

    public Warranty findOne(long id){

        return warrantyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("xx"));
    }

    public Iterable<Warranty> findAll(){
        return warrantyRepository.findAll();
    }

    public Warranty save(Warranty warranty){
        return warrantyRepository.save(warranty);
    }

    public void delete(long id){
        warrantyRepository.deleteById(id);
    }
}
