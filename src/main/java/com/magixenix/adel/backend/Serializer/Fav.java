package com.magixenix.adel.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.magixenix.adel.backend.models.Favorite;
import com.magixenix.adel.backend.models.Image;

import java.io.IOException;

public class Fav extends StdSerializer<Favorite> {

    public Fav(){this(null);}
    protected Fav(Class<Favorite> t) {
        super(t);
    }

    @Override
    public void serialize(Favorite value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("url",value.getImage().getUrl());
        gen.writeObjectField("title",value.getImage().getGallery().getTitle());
        gen.writeEndObject();

    }
}
