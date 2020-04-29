package com.magixenix.adel.backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.magixenix.adel.backend.Serializer.ImgSerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.security.cert.LDAPCertStoreParameters;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "image")
@JsonSerialize(using = ImgSerializer.class)
@Proxy(lazy = false)
@Transactional
public class Image extends AuditModel implements Serializable {



    @NotNull
    @Column(name = "url")
    private String url;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gallery_id", referencedColumnName = "id")
    private Gallery gallery;


    public String getUrl() {

        return "https://33f486a6.ngrok.io/"+url;
    }

}
