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

import com.store.backend.services.SellerService;
import com.store.backend.data.SellerData;

@RestController
@RequestMapping(path = "/api/sellers")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class SellerController {

    @Autowired
    private SellerService sellerService;

    // Listar todas los sellers
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(sellerService.findAll(), HttpStatus.OK);
    }

    // Listar un seller (por id)
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(sellerService.findById(id), HttpStatus.OK);
    }

    // Agregar un seller
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody SellerData seller) {
        return new ResponseEntity<>(sellerService.insert(seller), HttpStatus.CREATED);
    }

    // Editar un seller
    @PutMapping
    public ResponseEntity<?> update(@RequestBody SellerData seller) {
        return new ResponseEntity<>(sellerService.update(seller), HttpStatus.OK);
    }

    // Eliminar un seller
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(sellerService.deleteById(id), HttpStatus.OK);
    }

}