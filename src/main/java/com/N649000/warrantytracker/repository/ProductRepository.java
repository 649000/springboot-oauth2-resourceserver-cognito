package com.N649000.warrantytracker.repository;

import com.N649000.warrantytracker.model.Product;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

@EnableScan
public interface ProductRepository extends CrudRepository<Product, String> {
    List<Product> findProductsByWarrantyExpiryDateIsBetween(Date beforeDate, Date afterDate);
}
