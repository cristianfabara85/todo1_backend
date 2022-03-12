package com.todo1.hulkstore.repository;

import java.util.List;
import com.todo1.hulkstore.entities.CatalogProduct;
import com.todo1.hulkstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT productoId, codigo, nombre FROM public.productos", nativeQuery = true)
    List<CatalogProduct> findCatalogProducts();

    @Query(value = "SELECT productoId, codigo, nombre FROM public.productos WHERE productos.productoid NOT IN (SELECT productoid FROM inventario)", nativeQuery = true)
    List<CatalogProduct> findAllCatalogProducts();


}
