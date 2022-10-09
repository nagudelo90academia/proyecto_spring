package com.store.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.backend.entities.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

}
