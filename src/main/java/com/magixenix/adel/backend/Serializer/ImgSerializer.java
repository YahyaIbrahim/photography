package com.magixenix.adel.backend.Serializer;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.magixenix.adel.backend.models.Image;

import java.io.IOException;

public class ImgSerializer extends StdSerializer<Image> {

    public ImgSerializer(){this(null);}
    protected ImgSerializer(Class<Image> t) {
        super(t);
    }

    @Override
    public void serialize(Image value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("url",value.getUrl());
        gen.writeObjectField("title",value.getGallery().getTitle());
        gen.writeEndObject();

    }

}
