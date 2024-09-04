package com.Project.InventoryManagement.service;
import com.Project.InventoryManagement.model.Inventory;
import com.Project.InventoryManagement.model.Product;
import com.Project.InventoryManagement.repository.InventoryRepository;
import com.Project.InventoryManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    public Inventory updateInventory(Long id, Integer quantity) {
        return inventoryRepository.findById(id)
                .map(inventory -> {
                    inventory.setQuantity(quantity);
                    inventory.setLastUpdated(new Date());
                    return inventoryRepository.save(inventory);
                })
                .orElse(null);
    }

    public Inventory addInventory(Long productId, Integer quantity) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            Inventory inventory = new Inventory();
            inventory.setProduct(product);
            inventory.setQuantity(quantity);
            inventory.setLastUpdated(new Date());
            return inventoryRepository.save(inventory);
        }
        return null;
    }

}

