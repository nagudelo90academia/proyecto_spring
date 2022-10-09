package com.findajob.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.findajob.backend.converters.CategoryConverter;
import com.findajob.backend.data.CategoryData;
import com.findajob.backend.entities.Category;
import com.findajob.backend.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryConverter categoryConverter = new CategoryConverter();

    // Listar todas las categorias
    public List<CategoryData> findAll() {
        return categoryConverter.toData(categoryRepository.findAll());
    }

    // Listar una categoria (por id)
    public CategoryData findById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡La categoria no existe!");
        return categoryConverter.toData(category.get());
    }

    // Agregar una categoria
    public CategoryData insert(CategoryData category) {
        if (categoryRepository.existsById(category.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡La categoria ya existe!");
        return categoryConverter.toData(categoryRepository.save(categoryConverter.toEntity(category)));
    }

    // Editar una categoria
    public CategoryData update(CategoryData category) {
        if (!categoryRepository.existsById(category.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡La categoria no existe!");
        return categoryConverter.toData(categoryRepository.save(categoryConverter.toEntity(category)));
    }

    // Eliminar una categoria
    public CategoryData deleteById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡La categoria no existe!");
        CategoryData categoryData = categoryConverter.toData(category.get());
        categoryRepository.deleteById(id);
        return categoryData;
    }

}