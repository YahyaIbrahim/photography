package com.magixenix.adel.backend.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationDTO {

    @NotNull
    @Pattern(regexp = "[\\w\\s]+")
    String name;


    @NotNull
    @Size(min = 8, max = 60, message = "(Error: Password should be from 12 to 30 characters)")
    String password;


    @NotNull
    //@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
    @Email(message = "(Error: Please enter a valid email address)")
    String email;

    @Size(min = 11, message = "(Error: enter a valid phone number")
    @Pattern(regexp = "^[0-9]*$")
    String phone;



}
