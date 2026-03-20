package com.ecommerce.monolith.customer.service;

import com.ecommerce.monolith.customer.dto.CustomerDTO;
import com.ecommerce.monolith.customer.dto.CustomerRequest;
import com.ecommerce.monolith.customer.mapper.CustomerMapper;
import com.ecommerce.monolith.customer.model.Customer;
import com.ecommerce.monolith.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor // Génère le constructeur pour l'injection des dépendances
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public CustomerDTO createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        Customer saved = repository.save(customer);
        return mapper.toDTO(saved);
    }

    @Override
    public boolean existsById(Long id) {
        // Cette méthode est cruciale pour l'exercice (vérification d'existence)
        return repository.existsById(id);
    }
}