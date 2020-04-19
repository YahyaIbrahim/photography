package com.magixenix.adel.backend.services;

import com.magixenix.adel.backend.models.Image;
import com.magixenix.adel.backend.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ImageService {

    @Autowired
    ImageRepository imageRepository;



    public List<Image> loadRand(){
        return imageRepository.findRand();
    }

    public List<Image> galleryList(String type){
        return imageRepository.findAllByGallery_Title(type);
    }







}
