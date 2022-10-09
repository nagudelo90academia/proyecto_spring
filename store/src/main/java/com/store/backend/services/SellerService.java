package com.store.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.store.backend.converters.SellerConverter;
import com.store.backend.repositories.SellerRepository;

import com.store.backend.entities.Seller;
import com.store.backend.data.SellerData;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    private SellerConverter sellerConverter = new SellerConverter();

    // Listar todos los sellers
    public List<SellerData> findAll() {
        return sellerConverter.toData(sellerRepository.findAll());
    }

    // Listar seller (por id)
    public SellerData findById(int id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        if (seller.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El vendedor no existe!");
        return sellerConverter.toData(seller.get());
    }

    // Agregar un seller
    public SellerData insert(SellerData seller) {
        if (sellerRepository.existsById(seller.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡El vendedor ya existe!");
        return sellerConverter.toData(sellerRepository.save(sellerConverter.toEntity(seller)));
    }

    // editar un seller
    public SellerData update(SellerData seller) {
        if (!sellerRepository.existsById(seller.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El vendedor no exite!");
        return sellerConverter.toData(sellerRepository.save(sellerConverter.toEntity(seller)));
    }

    // Eliminar un seller
    public SellerData deleteById(int id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        if (seller.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El vendedor no existe!");
        SellerData sellerData = sellerConverter.toData(seller.get());
        sellerRepository.deleteById(id);
        return sellerData;
    }

}