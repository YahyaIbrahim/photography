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
@Table(name = "gallery")
public class Gallery extends AuditModel {

    @NotNull
    @Column(name = "title")
    @Pattern(regexp = "[\\w\\s]+")
    private String title;

    @NotNull
    @Column(name = "sub_title")
    @Pattern(regexp = "[\\w\\s]+")
    private String sub_title;

    @NotNull
    @Column(name = "url")
    private String url;

    @JsonIgnore
    @OneToMany(mappedBy = "gallery", fetch = FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Image> images;



}
