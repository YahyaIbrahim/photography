package com.magixenix.adel.backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "offer")
public class Offer extends AuditModel {

    @NotNull
    @Column(name = "title")
    @Pattern(regexp = "[\\w\\s]+")
    private String title;

    @NotNull
    @Column(name = "sub_title")
    @Pattern(regexp = "[\\w\\s]+")
    private String subTitle;

    @NotNull
    @Column(name = "url")
    private String url;


    public String getUrl() {

        return "http://api.adels.xyz/"+url;
    }



}
