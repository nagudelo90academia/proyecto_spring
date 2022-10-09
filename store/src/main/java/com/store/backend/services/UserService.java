package com.findajob.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.findajob.backend.converters.UserConverter;
import com.findajob.backend.data.UserData;
import com.findajob.backend.entities.User;
import com.findajob.backend.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserConverter userConverter = new UserConverter();

    // Servicio para registrar en la BD (Se realiza la converción de adentro hacia
    // afuera)
    public UserData insert(UserData user) {
        if (userRepository.existsById(user.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        return userConverter.toData(userRepository.save(userConverter.toEntity(user)));
    }

    // Servicio para consultar todo en la tabla
    public List<UserData> findAll() {
        return userConverter.toData(userRepository.findAll());
    }

    // Consulta user por id
    public UserData findById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exists");
        return userConverter.toData(user.get());
    }

    // Actualiza un user
    public UserData update(UserData user) {
        if (!userRepository.existsById(user.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exists");
        return userConverter.toData(userRepository.save(userConverter.toEntity(user)));
    }

    // Elimina un user
    public UserData deleteById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exists");
        UserData userData = userConverter.toData(user.get());
        userRepository.deleteById(id);
        return userData;
    }
}