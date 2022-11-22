package com.N649000.warrantytracker.controller;

import com.N649000.warrantytracker.model.Company;
import com.N649000.warrantytracker.service.CompanyService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/company")
@Slf4j
public class CompanyController {

    //TODO: Adding validation
    //https://stackoverflow.com/questions/67454378/spring-boot-validation-with-spring-boot-starter-validation-is-not-working-for-sp
    private final CompanyService companyService;

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
    public Company getCompany(@PathVariable @NonNull String companyId) {
        log.debug("Company ID: {}", companyId);
        if(companyId==null){
            log.info("YUP ITS NULL");
        }
        return companyService.getCompany(companyId);
    }

    @PatchMapping("/{companyId}")
    public Company updateCompany (@PathVariable("companyId") String companyId, @RequestBody Company request) {
        log.debug("Company ID: {}", companyId);
        log.debug("Company Object: {}", request.toString());
        return companyService.updateCompany(companyId, request);
    }

    @DeleteMapping("/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany (@PathVariable String companyId) {
        log.debug("Company ID: {}", companyId);
        companyService.deleteCompany(companyId);
    }
}
