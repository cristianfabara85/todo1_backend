package com.todo1.hulkstore.services;

import java.util.Date;
import java.util.List;
import com.todo1.hulkstore.entities.Purchase;
import com.todo1.hulkstore.entities.Sale;
import com.todo1.hulkstore.repository.SalesRepository;
import com.todo1.hulkstore.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SalesServiceImpl  {

    @Autowired
    public SalesRepository salesRepository;

    @Autowired
    public StockRepository stockRepository;

    public List<Sale> findAllSales() {
        return salesRepository.findAll(Sort.by(Direction.DESC, "ventaId"));
    }

    public Sale create(Sale sale) {
        sale.setFechaRegistro(new Date());
            Sale response= salesRepository.save(sale);
            if(response.getVentaId()!=null){
                stockRepository.updateStocksale(response.getProductoId(),response.getCantidad());
                stockRepository.updateAvailableStock(response.getProductoId());
            }
            return response;
    }
}
