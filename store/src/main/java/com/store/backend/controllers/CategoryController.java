package com.findajob.backend.controllers;

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

import com.findajob.backend.services.CategoryService;
import com.findajob.backend.data.CategoryData;

@RestController
@RequestMapping(path = "/api/categories")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Listar todas las categorias
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    // Listar una categoria (por id)
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    // Agregar una categoria
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody CategoryData category) {
        return new ResponseEntity<>(categoryService.insert(category), HttpStatus.CREATED);
    }

    // Editar una categoria
    @PutMapping
    public ResponseEntity<?> update(@RequestBody CategoryData category) {
        return new ResponseEntity<>(categoryService.update(category), HttpStatus.OK);
    }

    // Eliminar una categoria
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(categoryService.deleteById(id), HttpStatus.OK);
    }

}