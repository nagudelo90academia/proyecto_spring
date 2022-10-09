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

import com.store.backend.services.BrandService;
import com.store.backend.data.BrandData;

@RestController
@RequestMapping(path = "/api/brands")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class BrandController {

    @Autowired
    private BrandService brandService;

    // Listar todas los brands
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(brandService.findAll(), HttpStatus.OK);
    }

    // Listar un brand (por id)
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(brandService.findById(id), HttpStatus.OK);
    }

    // Agregar un brand
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody BrandData brand) {
        return new ResponseEntity<>(brandService.insert(brand), HttpStatus.CREATED);
    }

    // Editar un brand
    @PutMapping
    public ResponseEntity<?> update(@RequestBody BrandData brand) {
        return new ResponseEntity<>(brandService.update(brand), HttpStatus.OK);
    }

    // Eliminar un brand
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(brandService.deleteById(id), HttpStatus.OK);
    }

}