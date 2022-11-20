package com.N649000.warrantytracker.repository;

import com.N649000.warrantytracker.model.Company;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface CompanyRepository extends CrudRepository<Company, String> {
}
