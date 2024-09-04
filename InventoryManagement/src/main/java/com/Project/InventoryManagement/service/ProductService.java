package com.Project.InventoryManagement.service;
import com.Project.InventoryManagement.model.Product;
import com.Project.InventoryManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setDescription(updatedProduct.getDescription());
                    product.setPrice(updatedProduct.getPrice());
                    product.setStockQuantity(updatedProduct.getStockQuantity());
                    return productRepository.save(product);
                })
                .orElse(null);
    }

    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }
}

