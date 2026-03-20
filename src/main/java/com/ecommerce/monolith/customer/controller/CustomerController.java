package com.ecommerce.monolith.customer.controller;

import com.ecommerce.monolith.customer.dto.CustomerDTO;
import com.ecommerce.monolith.customer.dto.CustomerRequest;
import com.ecommerce.monolith.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAll() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> checkExists(@PathVariable Long id) {
        // C'est ici qu'on répond à la question du TP sur l'existence du client
        return ResponseEntity.ok(customerService.existsById(id));
    }
}