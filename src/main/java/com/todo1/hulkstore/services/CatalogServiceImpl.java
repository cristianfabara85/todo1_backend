package com.todo1.hulkstore.services;

import java.util.List;
import java.util.Optional;
import com.todo1.hulkstore.entities.Catalog;
import com.todo1.hulkstore.entities.CatalogProduct;
import com.todo1.hulkstore.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl {

    @Autowired
    public CatalogRepository catalogRepository;

    public Optional<Catalog> findById(Long id) {
        return catalogRepository.findById(id);
    }

    public List<Catalog> findAllCatalogs() {
        return catalogRepository.findAllCatalogs();
    }

    public List<Catalog> findCatalogsByType(Integer tipo) {
        return catalogRepository.findCatalogsByType(tipo);
    }

    public List<CatalogProduct> findAllProducts() {
        return catalogRepository.findAllProducts();
    }

    public List<CatalogProduct> findAllCatalogProducts() {
        return catalogRepository.findAllCatalogProducts();
    }

}
