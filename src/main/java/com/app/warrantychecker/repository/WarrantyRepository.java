package com.app.warrantychecker.repository;

import com.app.warrantychecker.model.Warranty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarrantyRepository extends CrudRepository<Warranty, Long> {
}
