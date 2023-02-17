package com.N649000.warrantytracker.model;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@org.mapstruct.Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Mapper {

    @Mapping(target="id", ignore=true)
    Company updateCompany(Company request, @MappingTarget Company company);

    @Mapping(target="id", ignore=true)
    @Mapping(target="userId", ignore=true)
    Product updateProduct(Product request, @MappingTarget Product product);
}
