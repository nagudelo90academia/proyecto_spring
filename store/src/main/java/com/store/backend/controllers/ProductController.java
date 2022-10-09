package com.store.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.store.backend.services.ProductService;
import com.store.backend.data.ProductData;

@RestController
@RequestMapping(path = "/api/products")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ProductController {

    @Autowired
    private ProductService productService;

    // Listar todas las products
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    // Listar una products (por id)
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    // Agregar una products
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ProductData product) {
        return new ResponseEntity<>(productService.insert(product), HttpStatus.CREATED);
    }

    // Editar una products
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductData product) {
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
    }

    // Eliminar una products
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(productService.deleteById(id), HttpStatus.OK);
    }

}