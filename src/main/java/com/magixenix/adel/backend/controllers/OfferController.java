package com.magixenix.adel.backend.controllers;

import com.magixenix.adel.backend.exceptions.SuccessList;
import com.magixenix.adel.backend.services.OfferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Offer APIs", tags = {"Offer"},
        description = "Offer operation")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @ApiOperation(value = "load All Offers")
    @GetMapping(path = "/offer", produces = "application/json")
    public SuccessList load(){
        return new SuccessList(200,offerService.loadAllGalleries(),null);
    }

}
