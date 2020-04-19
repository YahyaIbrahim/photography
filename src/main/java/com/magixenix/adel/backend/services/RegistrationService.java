package com.magixenix.adel.backend.services;

import com.magixenix.adel.backend.dto.RegistrationDTO;
import com.magixenix.adel.backend.exceptions.SuccessEntity;
import com.magixenix.adel.backend.models.User;
import com.magixenix.adel.backend.models.VerificationToken;
import com.magixenix.adel.backend.repositories.UserRepository;
import com.magixenix.adel.backend.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class RegistrationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    VerificationTokenRepository verificationToken;

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    HttpServletRequest httpServletRequest;

    private static final String SUCCESSFUL_REGISTRATION = "Registration completed successfully!";
    private static final String FAILED_REGISTRATION = "Email is already registered please use another one!";


    public SuccessEntity register(RegistrationDTO registrationDTO) {

        // COMPLETED check if email exist
        boolean exists = emailExist(registrationDTO.getEmail());


        // TODO return verfication code and should send an email
        if (!exists) {

            User profile = new User(registrationDTO);

            profile = userRepository.save(profile);

            confirmRegistration(profile.getId());
            return new SuccessEntity(200, profile, null);

        }
        return new SuccessEntity(400, null,FAILED_REGISTRATION);
    }

    private boolean emailExist(String email) {
        User profile = userRepository.findByEmail(email);

        if (profile != null) {
            return true;
        }
        return false;
    }

    private void confirmRegistration(Long userid) {
        User user = userRepository.findFirstById(userid);
        String token = UUID.randomUUID().toString();
        VerificationToken myToken = new VerificationToken(token, user);
        verificationToken.save(myToken);

        String path = httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort();

        String recipientAddress = user.getEmail();
        String subject = "Adel - Registration Confirmation";
        String confirmationUrl = "/registrationConfirm?token=" + token;
        String message = "Thank you for creating account with Adel, " + user.getName() +
                "\n\nWelcome to Adel!\n" +
                "Please activate your account!\n\n" +
                "This link will be available for 24 hours only ";


        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + path + confirmationUrl);
        mailSender.send(email);

    }




}
