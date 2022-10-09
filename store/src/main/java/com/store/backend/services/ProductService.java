package com.store.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.store.backend.converters.ProductConverter;
import com.store.backend.data.ProductData;
import com.store.backend.entities.Product;
import com.store.backend.repositories.ProductRepository;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  ProductConverter productConverter = new ProductConverter();

  public List<ProductData> findAll() {
    return productConverter.toData(productRepository.findAll());
  }

  public ProductData findById(int id) {
    Optional<Product> product = productRepository.findById(id);
    if (!product.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El producto no existe!");
    }
    return productConverter.toData(product.get());
  }

  public ProductData insert(ProductData product) {
    if (productRepository.existsById(product.getId())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "¡El producto ya existe!");
    }
    Product productEntity = productConverter.toEntity(product);
    ProductData response = productConverter.toData(productRepository.save(productEntity));
    return response;
  }

  public ProductData update(ProductData product) {

    if (!productRepository.existsById(product.getId())) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El producto no existe!");
    }
    Product productEntity = productConverter.toEntity(product);
    ProductData response = productConverter.toData(productRepository.save(productEntity));
    return response;
  }

  public ProductData deleteById(int id) {
    Optional<Product> product = productRepository.findById(id);
    if (!product.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El producto no existe!");
    }
    ProductData response = productConverter.toData(product.get());
    productRepository.deleteById(id);
    return response;
  }

}