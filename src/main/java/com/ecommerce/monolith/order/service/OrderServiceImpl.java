package com.ecommerce.monolith.order.service;

import com.ecommerce.monolith.customer.service.CustomerService;
import com.ecommerce.monolith.order.dto.OrderRequest;
import com.ecommerce.monolith.order.model.Order;
import com.ecommerce.monolith.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService; // On injecte le service de l'autre module !

    @Override
    public Order createOrder(OrderRequest request) {
        // ÉTAPE CRUCIALE : Vérifier si le client existe dans le module Customer
        if (!customerService.existsById(request.getCustomerId())) {
            throw new RuntimeException("Cannot create order: Customer does not exist!");
        }

        // Si le client existe, on crée la commande
        Order order = new Order();
        order.setCustomerId(request.getCustomerId());
        order.setProductIds(request.getProductIds());
        order.setOrderDate(LocalDateTime.now());
        // On pourrait ajouter un calcul de prix total ici plus tard

        return orderRepository.save(order);
    }
}