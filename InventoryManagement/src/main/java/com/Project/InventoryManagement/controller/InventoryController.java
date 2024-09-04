package com.Project.InventoryManagement.controller;
import com.Project.InventoryManagement.model.Inventory;
import com.Project.InventoryManagement.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
//@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id);
    }

    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable Long id, @RequestParam Integer quantity) {
        return inventoryService.updateInventory(id, quantity);
    }

    @PostMapping("/{productId}")
    public Inventory addInventory(@PathVariable Long productId, @RequestParam Integer quantity) {
        return inventoryService.addInventory(productId, quantity);
    }
}

