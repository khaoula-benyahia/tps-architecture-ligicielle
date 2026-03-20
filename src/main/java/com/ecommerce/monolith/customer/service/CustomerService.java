package com.ecommerce.monolith.customer.service;

import com.ecommerce.monolith.customer.dto.CustomerDTO;
import com.ecommerce.monolith.customer.dto.CustomerRequest;
import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createCustomer(CustomerRequest request);
    // C'est l'étape 2 de ton exercice [cite: 161]
    boolean existsById(Long id);
}