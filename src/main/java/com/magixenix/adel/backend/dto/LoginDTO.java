package com.magixenix.adel.backend.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@ApiModel
@Getter
@Setter
public class LoginDTO {

    //    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
    @Email(message = "Please enter a valid email address")
    private String email;


    @Size(min = 8, max = 30, message = "Password should be from 8 to 30 characters")
    private String password;
}
