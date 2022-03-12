package com.todo1.hulkstore.repository;

import java.util.List;
import com.todo1.hulkstore.entities.Catalog;
import com.todo1.hulkstore.entities.CatalogProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CatalogRepository extends JpaRepository<Catalog,Long> {

    @Query(value = "SELECT productoId, codigo, nombre FROM public.productos", nativeQuery = true)
    List<CatalogProduct> findAllProducts();

    @Query(value = "SELECT productoId, codigo, nombre FROM public.productos ", nativeQuery = true)
    List<CatalogProduct> findAllCatalogProducts();

    @Query(value = "SELECT catalogoId, tipo, nombre,estado FROM public.catalogos", nativeQuery = true)
    List<Catalog> findAllCatalogs();

    @Query(value = "SELECT catalogoId, tipo, nombre, estado FROM public.catalogos WHERE catalogos.tipo = :tipo", nativeQuery = true)
    List<Catalog> findCatalogsByType(Integer tipo);

}
