package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OfferRepository extends JpaRepository<Offer,Long> {
}
