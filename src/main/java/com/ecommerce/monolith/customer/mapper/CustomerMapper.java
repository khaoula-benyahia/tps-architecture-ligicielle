package com.ecommerce.monolith.customer.mapper;

import com.ecommerce.monolith.customer.dto.CustomerDTO;
import com.ecommerce.monolith.customer.dto.CustomerRequest;
import com.ecommerce.monolith.customer.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    List<CustomerDTO> toDTOList(List<Customer> customers);
    Customer toEntity(CustomerRequest request);

    @Mapping(target = "id", ignore = true)
    void updateEntity(CustomerRequest request, @MappingTarget Customer customer);
}