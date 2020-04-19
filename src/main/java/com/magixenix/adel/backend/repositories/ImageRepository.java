package com.magixenix.adel.backend.repositories;

import com.magixenix.adel.backend.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {

    @Query(value="select * from image order by RAND()",nativeQuery = true)
    List<Image> findRand();


    List<Image> findAllByGallery_Title(String title);

    Image findByUrl(String url);






}
