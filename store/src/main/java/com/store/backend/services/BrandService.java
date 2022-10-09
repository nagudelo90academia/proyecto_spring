package com.store.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.store.backend.converters.BrandConverter;
import com.store.backend.repositories.BrandRepository;

import com.store.backend.entities.Brand;
import com.store.backend.data.BrandData;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    private BrandConverter brandConverter = new BrandConverter();

    // Listar todos los brands
    public List<BrandData> findAll() {
        return brandConverter.toData(brandRepository.findAll());
    }

    // Listar brand (por id)
    public BrandData findById(int id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡La Marca no existe!");
        return brandConverter.toData(brand.get());
    }

    // Agregar un brand
    public BrandData insert(BrandData brand) {
        if (brandRepository.existsById(brand.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡La Marca ya existe!");
        return brandConverter.toData(brandRepository.save(brandConverter.toEntity(brand)));
    }

    // editar un brand
    public BrandData update(BrandData brand) {
        if (!brandRepository.existsById(brand.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡La Marca no exite!");
        return brandConverter.toData(brandRepository.save(brandConverter.toEntity(brand)));
    }

    // Eliminar un brand
    public BrandData deleteById(int id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La Marca no existe!");
        BrandData brandData = brandConverter.toData(brand.get());
        brandRepository.deleteById(id);
        return brandData;
    }

}