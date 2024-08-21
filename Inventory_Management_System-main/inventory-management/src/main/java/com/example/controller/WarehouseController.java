package com.example.controller;

import com.example.model.Warehouse;
import com.example.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    // Add a new warehouse
    @PostMapping("/addWarehouse")
    public ResponseEntity<Warehouse> addWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse newWarehouse = warehouseService.addWarehouse(warehouse);
        return ResponseEntity.ok(newWarehouse);
    }

    // Edit an existing warehouse
    @PutMapping("/{warehouseId}")
    public ResponseEntity<Warehouse> editWarehouse(@PathVariable Long warehouseId,
            @RequestBody Warehouse warehouseDetails) {
        Warehouse updatedWarehouse = warehouseService.editWarehouse(warehouseId, warehouseDetails);
        return ResponseEntity.ok(updatedWarehouse);
    }

    // Delete a warehouse
    @DeleteMapping("/{warehouseId}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long warehouseId) {
        warehouseService.deleteWarehouse(warehouseId);
        return ResponseEntity.noContent().build();
    }

    // View a specific warehouse by ID
    @GetMapping("/{warehouseId}")
    public ResponseEntity<Warehouse> viewWarehouse(@PathVariable Long warehouseId) {
        Warehouse warehouse = warehouseService.viewWarehouse(warehouseId);
        return ResponseEntity.ok(warehouse);
    }

    // View all warehouses
    @GetMapping
    public ResponseEntity<List<Warehouse>> viewAllWarehouses() {
        List<Warehouse> warehouses = warehouseService.viewAllWarehouses();
        return ResponseEntity.ok(warehouses);
    }
}
