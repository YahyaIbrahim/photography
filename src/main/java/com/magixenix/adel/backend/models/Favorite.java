package com.magixenix.adel.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "favorite")
public class Favorite extends AuditModel {
    @ManyToOne(targetEntity = User.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;


    @ManyToOne(targetEntity = Image.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "image_id", nullable = false)
    private Image image;

    public Favorite(){
    }
    public Favorite(User user1, Image image1){
        this.image = image1;
        this.user = user1;
    }

}
