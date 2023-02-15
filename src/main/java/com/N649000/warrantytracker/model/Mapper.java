package com.N649000.warrantytracker.model;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    @Mapping(target="id", ignore=true)
    Company updateCompany(Company request, @MappingTarget Company company);

    @Mapping(target="id", ignore=true)
    Product updateProduct(Product request, @MappingTarget Product product);
}
