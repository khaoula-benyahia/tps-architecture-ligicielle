import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
package com.ecommerce.monolith.product.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du tapis est obligatoire") // Empeche un nom vide
    private String name;

    private String description;

    @Positive(message = "Le prix doit être supérieur à zéro") // Empeche un prix négatif
    private double price;

    @Min(value = 0, message = "Le stock ne peut pas être négatif") // Empeche un stock illogique
    private int stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}