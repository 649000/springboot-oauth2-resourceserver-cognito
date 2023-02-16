package com.N649000.warrantytracker.controller;

import com.N649000.warrantytracker.model.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

@RestController
@RequestMapping(value = "/api/foos")
@Slf4j
public class FooController {

    /**
     * Example method to retrieve claims from JWT token
     *
     * @param id
     * @param authentication Based on @CurrentSecurityContext in Spring Security 5
     * @return
     */
    @GetMapping(value = "/{id}")
    public Foo findOne(@PathVariable Long id, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        // Authentication#getName maps to the JWT’s sub property,
        log.info(authentication.getName().toString());

        // Authentication#getPrincipal is a Spring Security Jwt object
        log.info(authentication.getPrincipal().toString());
        Jwt jwt = (Jwt) authentication.getPrincipal();
        log.info(jwt.getClaims().toString());

        return new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4));
    }

    /**
     * Example method to retrieve claims from JWT token
     *
     * @param jwt Principal objects are JWT object, @AuthenticationPrincipal is based on Spring Security 4
     * @return
     */
    @GetMapping
    public List findAll(@AuthenticationPrincipal Jwt jwt) {
        log.info(jwt.getSubject().toString());
        log.info(jwt.getClaims().toString());

        List fooList = new ArrayList();
        fooList.add(new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4)));
        fooList.add(new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4)));
        return fooList;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Foo newFoo) {
        log.info("Foo created");
    }
}
