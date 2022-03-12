package com.todo1.hulkstore.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import com.todo1.hulkstore.entities.CatalogProduct;
import com.todo1.hulkstore.entities.Product;
import com.todo1.hulkstore.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.OPTIONS,RequestMethod.GET,
    RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;


    @GetMapping("/findall")
    private ResponseEntity<List<Product>> findAllProducts (){
        List<Product> productList = productServiceImpl.findAllProducts();
        try {
            return ResponseEntity.ok(productList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };


    @PostMapping("/save")
    @ResponseBody
    private ResponseEntity<Product> saveProduct (@RequestBody Product product){
        Product obj = productServiceImpl.create(product);

        try {
            return ResponseEntity.created(new URI("/api/hulkstore/save"+obj.getProductoId())).body(obj);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteProduct (@PathVariable Long id){
        productServiceImpl.deleteById(id);
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @GetMapping(name="/getbyid/{id}", value = "{id}")
    private ResponseEntity<Optional<Product>> findById (@PathVariable Long id){
        Optional<Product> productResponse = productServiceImpl.getById(id);
        try {
            return ResponseEntity.ok(productResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @PostMapping("/update")
    @ResponseBody
    private ResponseEntity<Product> updateProduct (@RequestBody Product product){
        Product productCreate = productServiceImpl.create(product);

        try {
            return ResponseEntity.created(new URI("/api/hulkstore/save"+productCreate.getProductoId())).body(productCreate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @GetMapping("/catalog")
    private ResponseEntity<List<CatalogProduct>> catalogProduct (){
        List<CatalogProduct> productListAll = productServiceImpl.findCatalogProducts();
        try {
            return ResponseEntity.ok(productListAll);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @GetMapping("/catalogAll")
    private ResponseEntity<List<CatalogProduct>> catalogAllProduct (){
        List<CatalogProduct> productListAll = productServiceImpl.findAllCatalogProducts();
        try {
            return ResponseEntity.ok(productListAll);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

}
