package com.magixenix.adel.backend.controllers;

import com.magixenix.adel.backend.dto.RegistrationDTO;
import com.magixenix.adel.backend.dto.TokenDTO;
import com.magixenix.adel.backend.exceptions.SuccessEntity;
import com.magixenix.adel.backend.models.User;
import com.magixenix.adel.backend.models.VerificationToken;
import com.magixenix.adel.backend.repositories.VerificationTokenRepository;
import com.magixenix.adel.backend.services.RegistrationService;
import com.magixenix.adel.backend.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@Api(value = "Registration APIs", tags = {"Registration Management"},
        description = "Registration operations")
@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    VerificationTokenRepository tokenRepository;

    @Autowired
    UserService userService;

    @PostMapping(path = "/signup")
    public SuccessEntity register(@RequestBody RegistrationDTO registrationDTO) {

        return registrationService.register(registrationDTO);
    }

    @ApiOperation(value = "registrationConfirm")
    @PostMapping(path = "/registrationConfirm")
    public SuccessEntity confirmRegistration
            (@RequestBody TokenDTO token) {
        VerificationToken verificationToken = tokenRepository.findByToken(token.getToken());
        if (verificationToken == null) {
            String message = "Invalid token";
            return new SuccessEntity(400, null,message);
        }
        User user = verificationToken.getProfile();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            String messageValue = "Verification link expired!";
            return new SuccessEntity(400, null,messageValue);

        }

        user.setEnabled(true);
        userService.save(user);

        return new SuccessEntity(200, user, null);

    }

}
