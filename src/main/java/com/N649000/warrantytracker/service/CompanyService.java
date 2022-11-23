package com.N649000.warrantytracker.service;

import com.N649000.warrantytracker.exception.EntityNotFoundException;
import com.N649000.warrantytracker.model.Company;
import com.N649000.warrantytracker.model.Mapper;
import com.N649000.warrantytracker.repository.CompanyRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final Mapper mapper;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, Mapper mapper) {
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

    public Company createCompany (@NonNull Company company){
        return companyRepository.save(company);
    }

    public Iterable<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public Company getCompany(@NonNull final String companyId) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        if(optionalCompany.isPresent()) {
            return optionalCompany.get();
        }
        throw new EntityNotFoundException("Company Not Found");
    }

    public void deleteCompany(@NonNull final String companyId){
        companyRepository.deleteById(companyId);
    }

    public Company updateCompany(@NonNull final String companyId, @NonNull final Company request) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        if (optionalCompany.isEmpty()) {
            throw new EntityNotFoundException("Company Not Found");
        }

        Company newCompany = mapper.updateCompany(request, optionalCompany.get());
        return companyRepository.save(newCompany);
    }
}
