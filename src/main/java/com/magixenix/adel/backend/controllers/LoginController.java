package com.magixenix.adel.backend.controllers;


import com.magixenix.adel.backend.dto.LoginDTO;
import com.magixenix.adel.backend.exceptions.SuccessEntity;
import com.magixenix.adel.backend.models.User;
import com.magixenix.adel.backend.services.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Login APIs", tags = {"Login"},
        description = "Login operation")

public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "Login with Email , Password")
    @PostMapping(path = "/login", produces = "application/json")
    public SuccessEntity Login(@RequestBody LoginDTO profileDTO) {

        // String password = new BCryptPasswordEncoder().encode(profileDTO.getPassword());
        User profile = loginService.login(profileDTO.getEmail(),profileDTO.getPassword());
        if(profile != null)
            /*
            return profile;
        return null;
*/

            return new SuccessEntity(200, profile, null);
        return new SuccessEntity(400, null,"User Not Found");


    }

}
