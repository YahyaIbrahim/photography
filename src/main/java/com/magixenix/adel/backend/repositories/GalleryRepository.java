package com.magixenix.adel.backend.repositories;

import com.magixenix.adel.backend.models.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface GalleryRepository extends JpaRepository<Gallery,Long> {


    List<Gallery> findAll();

}
