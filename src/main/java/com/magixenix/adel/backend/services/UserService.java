package com.magixenix.adel.backend.services;

import com.magixenix.adel.backend.exceptions.SuccessEntity;
import com.magixenix.adel.backend.exceptions.SuccessString;
import com.magixenix.adel.backend.models.Favorite;
import com.magixenix.adel.backend.models.Image;
import com.magixenix.adel.backend.models.User;
import com.magixenix.adel.backend.repositories.FavoriteRepo;
import com.magixenix.adel.backend.repositories.ImageRepository;
import com.magixenix.adel.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    FavoriteRepo favoriteRepo;

    public void save(User profile){
        userRepository.save(profile);
    }

    public User loadProfile(Long profileId) {
        // TODO loading profile data

        User user = userRepository.findFirstById(profileId);
        if(user.isEnabled()){
            return user;
        }
        return null;
    }

    public SuccessEntity editByEmail(String email, User profileDTO) {

        User updatedUser = userRepository.findByEmail(email);

        if(profileDTO.getName() != null)
            updatedUser.setName(profileDTO.getName());

        if(profileDTO.getPassword() != null)
            updatedUser.setPassword(profileDTO.getPassword());

        if(profileDTO.getPhone() != null)
            updatedUser.setPhone(profileDTO.getPhone());

        User profile = userRepository.save(updatedUser);

        return new SuccessEntity(200, profile, null);
    }


    public String addFavorite(String email,String url){

        User user=userRepository.findByEmail(email);
        Image image = imageRepository.findByUrl(url);

        Favorite favorite = new Favorite(user,image);

        favoriteRepo.save(favorite);

        return "Added to Favorite";
    }

    public String deleteFavorite(String email,String url){

        User user=userRepository.findByEmail(email);
        Image image = imageRepository.findByUrl(url);

        Favorite favorite = new Favorite(user,image);

        favoriteRepo.delete(favorite);

        return "Deleted from Favorite";
    }


    public List<String> loadImages(String email){
        User u = userRepository.findByEmail(email);
        List<Favorite> favorites = favoriteRepo.findByUser(u);
        List<String> images = null;

        for (Favorite i:favorites) {
            images.add(i.getImage().getUrl());
        }

        return images;
    }
}
