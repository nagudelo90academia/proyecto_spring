package com.store.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.backend.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}