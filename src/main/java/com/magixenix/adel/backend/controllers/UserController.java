package com.magixenix.adel.backend.controllers;


import com.magixenix.adel.backend.exceptions.SuccessEntity;
import com.magixenix.adel.backend.exceptions.SuccessList;
import com.magixenix.adel.backend.exceptions.SuccessString;
import com.magixenix.adel.backend.models.Image;
import com.magixenix.adel.backend.models.User;
import com.magixenix.adel.backend.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "User APIs", tags = {"User Management"},
        description = "User operation")
public class UserController {
    @Autowired
    private UserService profileService;

    @ApiOperation(value = "Updates profile.",produces = "application/json")
    @PostMapping(path = "/edit/{email}")
    public SuccessEntity editByEmail(@PathVariable("email") String email, @RequestBody User profile) {
        return profileService.editByEmail(email, profile);
    }

    @ApiOperation(value = "AddFavorite",produces = "application/json")
    @PostMapping(path = "/add/{email}/{url}")
    public SuccessString addToFavorite(@PathVariable("email") String email, @PathVariable("url") String url ) {
        return new SuccessString(200,profileService.addFavorite(email, url),null);
    }


    @ApiOperation(value = "Delete from favorite",produces = "application/json")
    @DeleteMapping(path = "/delete/{email}/{url}")
    public SuccessString deleteFavorite(@PathVariable("email") String email, @PathVariable("url") String url ) {
        return new SuccessString(200,profileService.deleteFavorite(email, url),null);
    }

    @ApiOperation(value = "Loads Media image")
    @GetMapping(path = "/{email}/media/images",produces = MediaType.APPLICATION_JSON_VALUE)
    public SuccessList loadMediaImage(@PathVariable String email) {
        try {
            List<String> photos = profileService.loadImages(email);
            return new SuccessList(200,  photos, null);
        }catch (NullPointerException d) {
            return new SuccessList(400,  null, "There's no Images");
        }

    }









}
