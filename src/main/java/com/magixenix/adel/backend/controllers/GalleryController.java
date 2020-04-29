package com.magixenix.adel.backend.controllers;


import com.magixenix.adel.backend.dto.AlbumDTO;
import com.magixenix.adel.backend.exceptions.SuccessList;

import com.magixenix.adel.backend.models.Image;
import com.magixenix.adel.backend.services.GalleryService;
import com.magixenix.adel.backend.services.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "Gallery APIs", tags = {"Gallery"},
        description = "Gallery operation")
public class GalleryController {
    @Autowired
    private GalleryService galleryService;

    @Autowired
    private ImageService imageService;




    @ApiOperation(value = "load All Galleries")
    @GetMapping(path = "/gallery", produces = "application/json")
    public SuccessList load(){
        return new SuccessList(200,galleryService.loadAllGalleries(),null);
    }

    @ApiOperation(value = "load All Album in Gallery")
    @GetMapping(path = "/gallery/{title}", produces = "application/json")
    public SuccessList loadByAlbum(@PathVariable("title") String title){
        return new SuccessList(200,imageService.galleryList(title),null);
    }

    @ApiOperation(value = "load All Galleries")
    @GetMapping(path = "/home", produces = "application/json")
    public SuccessList loadRand(){



        return new SuccessList(200,imageService.loadRand(),null);
    }


}
