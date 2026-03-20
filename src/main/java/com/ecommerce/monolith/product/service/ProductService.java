package com.ecommerce.monolith.product.service;

import com.ecommerce.monolith.product.dto.CreateProductRequest;
import com.ecommerce.monolith.product.dto.ProductDTO;
import java.util.List;

public interface ProductService {

    // Récupère tous les produits
    List<ProductDTO> getAllProducts();

    // Récupère un produit par son ID
    ProductDTO getProductById(Long id);

    // Crée un nouveau produit
    ProductDTO createProduct(CreateProductRequest request);

    // Met à jour un produit existant
    ProductDTO updateProduct(Long id, CreateProductRequest request);

    // Supprime un produit
    void deleteProduct(Long id);
}