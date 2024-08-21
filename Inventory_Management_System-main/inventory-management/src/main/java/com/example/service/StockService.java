package com.example.service;

import com.example.model.Stock;
import com.example.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock editStock(Long stockId, Stock stockDetails) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
        stock.setProduct(stockDetails.getProduct());
        stock.setWarehouse(stockDetails.getWarehouse());
        stock.setQuantity(stockDetails.getQuantity());
        return stockRepository.save(stock);
    }

    public void deleteStock(Long stockId) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
        stockRepository.delete(stock);
    }

    public Stock viewStock(Long stockId) {
        return stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    public List<Stock> viewAllStocks() {
        return stockRepository.findAll();
    }

    public List<Stock> getStocksByWarehouseId(Long warehouseId) {
        return stockRepository.findAllByWarehouseId(warehouseId);
    }

    public List<Stock> getStocksByProductId(Long productId) {
        return stockRepository.findAllByProductId(productId);
    }
}
