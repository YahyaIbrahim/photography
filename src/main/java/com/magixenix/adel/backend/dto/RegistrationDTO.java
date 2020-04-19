package com.magixenix.adel.backend.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationDTO {

    String name;
    String password;
    String email;
    String phone;



}
