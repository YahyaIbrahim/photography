package com.magixenix.adel.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.magixenix.adel.backend.Serializer.Fav;
import com.magixenix.adel.backend.Serializer.ImgSerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "favorite")
@JsonSerialize(using = Fav.class)
@Proxy(lazy = false)
@Transactional
public class Favorite extends AuditModel implements Serializable {
    @ManyToOne(targetEntity = User.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;


    @ManyToOne(targetEntity = Image.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "image_id", nullable = false)
    private Image image;


}
