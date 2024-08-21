package com.example.repository;

import com.example.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query("SELECT s FROM Stock s WHERE s.warehouse.warehouseId = :warehouseId")
    List<Stock> findAllByWarehouseId(@Param("warehouseId") Long warehouseId);

    @Query("SELECT s FROM Stock s WHERE s.product.productId = :productId")
    List<Stock> findAllByProductId(@Param("productId") Long productId);
}
