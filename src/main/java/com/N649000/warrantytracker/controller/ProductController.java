package com.N649000.warrantytracker.controller;

import com.N649000.warrantytracker.model.Product;
import com.N649000.warrantytracker.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/product")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct (@RequestBody Product request, @AuthenticationPrincipal Jwt jwt) {
        request.setUserId(jwt.getSubject());
        log.debug("Request Object: {}", request.toString());
        return productService.createProduct(request);
    }

    @GetMapping
    public Iterable<Product> getCompanies(){
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable String productId) {
        log.debug("Product ID: {}", productId);
        return productService.getProduct(productId);
    }

    @PatchMapping("/{productId}")
    public Product updateProduct (@PathVariable("productId") String productId, @RequestBody Product request) {
        log.debug("Product ID: {}", productId);
        log.debug("Request Object: {}", request.toString());
        return productService.updateProduct(productId, request);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook (@PathVariable String productId) {
        log.debug("Product ID: {}", productId);
        productService.deleteProduct(productId);
    }
}
