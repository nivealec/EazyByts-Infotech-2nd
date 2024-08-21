package com.example.controller;

import com.example.model.Supplier;
import com.example.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    // Add a new supplier
    @PostMapping("/addSupplier")
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier newSupplier = supplierService.addSupplier(supplier);
        return ResponseEntity.ok(newSupplier);
    }

    // Edit an existing supplier
    @PutMapping("/{supplierId}")
    public ResponseEntity<Supplier> editSupplier(@PathVariable Long supplierId, @RequestBody Supplier supplierDetails) {
        Supplier updatedSupplier = supplierService.editSupplier(supplierId, supplierDetails);
        return ResponseEntity.ok(updatedSupplier);
    }

    // Delete a supplier
    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long supplierId) {
        supplierService.deleteSupplier(supplierId);
        return ResponseEntity.noContent().build();
    }

    // View a specific supplier by ID
    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> viewSupplier(@PathVariable Long supplierId) {
        Supplier supplier = supplierService.viewSupplier(supplierId);
        return ResponseEntity.ok(supplier);
    }

    // View all suppliers
    @GetMapping
    public ResponseEntity<List<Supplier>> viewAllSuppliers() {
        List<Supplier> suppliers = supplierService.viewAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }
}
