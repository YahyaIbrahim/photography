package com.magixenix.adel.backend.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.magixenix.adel.backend.models.Gallery;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumDTO {

    private String email;

    private String url;




}
