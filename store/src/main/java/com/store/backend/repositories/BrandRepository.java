package com.store.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.backend.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
