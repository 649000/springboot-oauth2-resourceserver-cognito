package com.app.warrantychecker.repository;

import com.app.warrantychecker.model.User;
import com.app.warrantychecker.model.Warranty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarrantyRepository extends CrudRepository<Warranty, Long> {
    //Note that findByUser(String Email) does not work
    List<Warranty> findByUser(User user);
}
