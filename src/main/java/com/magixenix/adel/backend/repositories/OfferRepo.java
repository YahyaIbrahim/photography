package com.magixenix.adel.backend.repositories;


import com.magixenix.adel.backend.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepo extends JpaRepository<Offer,Long> {

    List<Offer> findAll();
}
