package com.magixenix.adel.backend.repositories;

import com.magixenix.adel.backend.models.Favorite;
import com.magixenix.adel.backend.models.Image;
import com.magixenix.adel.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FavoriteRepo extends JpaRepository<Favorite,Long> {


    List<Favorite> findByUser(User user);
}
