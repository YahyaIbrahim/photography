package com.magixenix.adel.backend.services;

import com.magixenix.adel.backend.models.User;
import com.magixenix.adel.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoginService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    public User login(String email, String password){
        User profile =  userRepository.findByEmailAndPassword(email, password);

        if (profile != null){
          return   userService.loadProfile(profile.getId());
        }
      return null;
    }

}
