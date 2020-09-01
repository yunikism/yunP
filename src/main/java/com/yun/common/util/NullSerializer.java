package com.yun.common.util;




import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by taz on 2017-08-15.
 */
public class NullSerializer extends JsonSerializer<Object> {

    @Override
    public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString("");
    }
}
