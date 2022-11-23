package com.N649000.warrantytracker.service;

import com.N649000.warrantytracker.exception.EntityNotFoundException;
import com.N649000.warrantytracker.model.Company;
import com.N649000.warrantytracker.model.Mapper;
import com.N649000.warrantytracker.model.Product;
import com.N649000.warrantytracker.repository.CompanyRepository;
import com.N649000.warrantytracker.repository.ProductRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final CompanyRepository companyRepository;
    private final Mapper mapper;

    @Autowired
    public ProductService(ProductRepository productRepository, CompanyRepository companyRepository, Mapper mapper) {
        this.productRepository = productRepository;
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

    public Product createProduct (@NonNull Product product){
        return productRepository.save(product);
    }

    public Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(@NonNull final String productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new EntityNotFoundException("Product Not Found");
    }

    public void deleteProduct(@NonNull final String productId){
        productRepository.deleteById(productId);
    }


    public Product  updateProduct(@NonNull final String productId, @NonNull final Product request){
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()) {
            throw new EntityNotFoundException("Product Not Found");
        }

        if (request.getCompanyId() != null) {
            Optional<Company> optionalCompany = companyRepository.findById(request.getCompanyId());
            if (optionalCompany.isEmpty()){
                throw new EntityNotFoundException("Invalid Company Id");
            }
        }
        Product product = mapper.updateProduct(request, optionalProduct.get());
        return productRepository.save(product);
    }

}
