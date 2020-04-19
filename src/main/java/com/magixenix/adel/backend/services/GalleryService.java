package com.magixenix.adel.backend.services;



import com.magixenix.adel.backend.models.Gallery;

import com.magixenix.adel.backend.models.Image;
import com.magixenix.adel.backend.repositories.GalleryRepository;
import com.magixenix.adel.backend.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GalleryService {

    @Autowired
    GalleryRepository galleryRepository;

    @Autowired
    ImageRepository imageRepository;

    public List<Gallery> loadAllGalleries(){
        return galleryRepository.findAll();
    }





}
