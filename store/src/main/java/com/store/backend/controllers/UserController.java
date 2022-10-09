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

import com.store.backend.services.UserService;
import com.store.backend.data.UserData;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class UserController {

    @Autowired
    private UserService userService;

    // Listar todas los roles
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    // Listar un rol (por id)
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    // Agregar un rol
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UserData user) {
        return new ResponseEntity<>(userService.insert(user), HttpStatus.CREATED);
    }

    // Editar un rol
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserData user) {
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    // Eliminar un rol
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(userService.deleteById(id), HttpStatus.OK);
    }

}