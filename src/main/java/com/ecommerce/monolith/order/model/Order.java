package com.ecommerce.monolith.order.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders") // Pour éviter les conflits avec le mot clé SQL 'ORDER'
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId; // On stocke juste l'ID du client (indépendance !)

    @ElementCollection
    private List<Long> productIds; // Liste des IDs des produits commandés

    private Double totalAmount;
    private LocalDateTime orderDate;
}
