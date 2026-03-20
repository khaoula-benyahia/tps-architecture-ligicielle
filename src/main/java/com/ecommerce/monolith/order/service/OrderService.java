package com.ecommerce.monolith.order.service;

import com.ecommerce.monolith.order.dto.OrderRequest;
import com.ecommerce.monolith.order.model.Order;

public interface OrderService {
    Order createOrder(OrderRequest request);
}
