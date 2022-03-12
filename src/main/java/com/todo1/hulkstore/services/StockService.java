package com.todo1.hulkstore.services;

import java.util.List;
import com.todo1.hulkstore.entities.Stock;
import com.todo1.hulkstore.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    public StockRepository stockRepository;

    public List<Stock> findAllStock() {
        return stockRepository.findAll();
    }

    public void updateStockPurchase(Long productoId, Long cantidad) {
        stockRepository.updateStockPurchase(productoId, cantidad);
    }

}
