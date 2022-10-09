package com.findajob.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.findajob.backend.converters.RoleConverter;
import com.findajob.backend.repositories.RoleRepository;

import com.findajob.backend.entities.Role;
import com.findajob.backend.data.RoleData;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    private RoleConverter roleConverter = new RoleConverter();

    // Listar todos los roles
    public List<RoleData> findAll() {
        return roleConverter.toData(roleRepository.findAll());
    }

    // Listar role (por id)
    public RoleData findById(int id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El rol no existe!");
        return roleConverter.toData(role.get());
    }

    // Agregar un role
    public RoleData insert(RoleData role) {
        if (roleRepository.existsById(role.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡El rol ya existe!");
        return roleConverter.toData(roleRepository.save(roleConverter.toEntity(role)));
    }

    // editar un role
    public RoleData update(RoleData role) {
        if (!roleRepository.existsById(role.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El rol no exite!");
        return roleConverter.toData(roleRepository.save(roleConverter.toEntity(role)));
    }

    // Eliminar un role
    public RoleData deleteById(int id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol no existe!");
        RoleData rolData = roleConverter.toData(role.get());
        roleRepository.deleteById(id);
        return rolData;
    }

}