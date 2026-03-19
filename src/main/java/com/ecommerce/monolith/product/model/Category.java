package com.ecommerce.monolith.product.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // ICI, on met le OneToMany (une catégorie vers plusieurs produits)
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}