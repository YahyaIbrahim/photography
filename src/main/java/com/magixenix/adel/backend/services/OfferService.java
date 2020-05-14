package com.magixenix.adel.backend.services;


import com.magixenix.adel.backend.models.Offer;
import com.magixenix.adel.backend.repositories.OfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OfferService {

    @Autowired
    OfferRepo offerRepo;



    public List<Offer> loadAllGalleries(){
        return offerRepo.findAll();
    }

}
