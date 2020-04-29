package com.magixenix.adel.backend.controllers;


import com.magixenix.adel.backend.dto.AlbumDTO;
import com.magixenix.adel.backend.exceptions.SuccessEntity;
import com.magixenix.adel.backend.exceptions.SuccessList;
import com.magixenix.adel.backend.exceptions.SuccessString;
import com.magixenix.adel.backend.models.Favorite;
import com.magixenix.adel.backend.models.Image;
import com.magixenix.adel.backend.models.User;
import com.magixenix.adel.backend.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(value = "User APIs", tags = {"User Management"},
        description = "User operation")
public class UserController {
    @Autowired
    private UserService profileService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @ApiOperation(value = "Updates profile.")
    @PostMapping(path = "/edit/{email}",produces = "application/json")
    public SuccessEntity editByEmail(@PathVariable("email") String email, @RequestBody User profile) {
        return profileService.editByEmail(email, profile);
    }

    @ApiOperation(value = "AddFavorite")
    @PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SuccessString addToFavorite(@RequestBody AlbumDTO albumDTO) {
        //String serverPath = "https://"+httpServletRequest.getServerName()+"/";
        String path = "https://adels.xyz/";
        String string = albumDTO.getUrl().substring(path.length());
        return new SuccessString(200,profileService.addFavorite(albumDTO.getEmail(),string),null);
    }


    @ApiOperation(value = "Delete from favorite")
    @DeleteMapping(path = "/delete",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SuccessString deleteFavorite(@RequestBody AlbumDTO albumDTO) {
       // String serverPath = "https://"+httpServletRequest.getServerName()+"/";
        String path = "https://adels.xyz/";
        String string = albumDTO.getUrl().substring(path.length());
        return new SuccessString(200,profileService.deleteFavorite(albumDTO.getEmail(),string),null);
    }

    @ApiOperation(value = "Loads Media image")
    @GetMapping(path = "/{email}/media/images",produces = MediaType.APPLICATION_JSON_VALUE)
    public SuccessList loadMediaImage(@PathVariable("email") String email) {
        try {
            List<Favorite> photos = profileService.loadImages(email);
            return new SuccessList(200,  photos, null);
        }catch (NullPointerException d) {
            return new SuccessList(400,  null, "There's no Images");
        }

    }









}
