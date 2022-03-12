package com.todo1.hulkstore.controller;

import java.net.URI;
import java.util.List;
import com.todo1.hulkstore.entities.Sale;
import com.todo1.hulkstore.services.SalesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.OPTIONS, RequestMethod.GET,
    RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/api/sale")
public class SalesController {


    @Autowired
    private SalesServiceImpl salesService;

    @GetMapping("/findall")
    private ResponseEntity<List<Sale>> findAllSales() {
        List<Sale> productList = salesService.findAllSales();
        try {
            return ResponseEntity.ok(productList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/save")
    @ResponseBody
    private ResponseEntity<Sale> saveProduct(@RequestBody Sale sale) {
        Sale obj = salesService.create(sale);

        try {
            return ResponseEntity.created(new URI("/api/hulkstore/save" + obj.getVentaId()))
                .body(obj);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
