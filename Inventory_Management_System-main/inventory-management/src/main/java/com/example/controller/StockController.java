package com.example.controller;

import com.example.model.Stock;
import com.example.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    // Add a new stock record
    @PostMapping("/addStock")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        Stock newStock = stockService.addStock(stock);
        return ResponseEntity.ok(newStock);
    }

    // Edit an existing stock record
    @PutMapping("/{stockId}")
    public ResponseEntity<Stock> editStock(@PathVariable Long stockId, @RequestBody Stock stockDetails) {
        Stock updatedStock = stockService.editStock(stockId, stockDetails);
        return ResponseEntity.ok(updatedStock);
    }

    // Delete a stock record
    @DeleteMapping("/{stockId}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long stockId) {
        stockService.deleteStock(stockId);
        return ResponseEntity.noContent().build();
    }

    // View a specific stock record by ID
    @GetMapping("/{stockId}")
    public ResponseEntity<Stock> viewStock(@PathVariable Long stockId) {
        Stock stock = stockService.viewStock(stockId);
        return ResponseEntity.ok(stock);
    }

    // View all stock records
    @GetMapping
    public ResponseEntity<List<Stock>> viewAllStocks() {
        List<Stock> stocks = stockService.viewAllStocks();
        return ResponseEntity.ok(stocks);
    }

    // Get all stock records by warehouse ID
    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<Stock>> getStocksByWarehouse(@PathVariable Long warehouseId) {
        List<Stock> stocks = stockService.getStocksByWarehouseId(warehouseId);
        return ResponseEntity.ok(stocks);
    }

    // Get all stock records by product ID
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Stock>> getStocksByProduct(@PathVariable Long productId) {
        List<Stock> stocks = stockService.getStocksByProductId(productId);
        return ResponseEntity.ok(stocks);
    }
}
