package com.N649000.warrantytracker.controller;

import com.N649000.warrantytracker.model.Company;
import com.N649000.warrantytracker.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/company")
@Slf4j
public class CompanyController {

    private final CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company createCompany (@RequestBody Company request) {
        log.debug("Company Object: {}", request.toString());
        return companyService.createCompany(request);
    }

    @GetMapping
    public Iterable<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping("/{companyId}")
    public Company getCompany(@PathVariable String companyId) {
        log.debug("Company ID: {}", companyId);
        return companyService.getCompany(companyId);
    }

    @PatchMapping("/{companyId}")
    public Company updateCompany (@PathVariable("companyId") String companyId, @RequestBody Company request) {
        log.debug("Company ID: {}", companyId);
        log.debug("Request Object: {}", request.toString());
        return companyService.updateCompany(companyId, request);
    }

    @DeleteMapping("/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany (@PathVariable String companyId) {
        log.debug("Company ID: {}", companyId);
        companyService.deleteCompany(companyId);
    }
}
