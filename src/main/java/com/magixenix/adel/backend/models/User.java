package com.magixenix.adel.backend.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.magixenix.adel.backend.dto.RegistrationDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends AuditModel {

    @Column(name = "enabled")
    private boolean enabled;

    @NotNull
    @Column(name = "name")
    @Pattern(regexp = "[\\w\\s]+")
    private String name;


    @NotNull
    @Size(min = 8, max = 60, message = "(Error: Password should be from 12 to 30 characters)")
    @Column(name = "password")
    private String password;


    @NotNull
    @Column(name = "email")
    //@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
    @Email(message = "(Error: Please enter a valid email address)")
    private String email;

    @Size(min = 11, message = "(Error: enter a valid phone number")
    @Column(name = "phone")
    @Pattern(regexp = "^[0-9]*$")
    private String phone;

    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "favorite",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private Set<Favorite> favorites;


    public User() {
    }

    public User(RegistrationDTO registrationDTO){
        this.name = registrationDTO.getName();
        this.email =registrationDTO.getEmail();
        this.password = registrationDTO.getPassword();
        this.phone = registrationDTO.getPhone();
        this.enabled = false;
    }





}
