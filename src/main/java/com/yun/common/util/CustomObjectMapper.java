package com.yun.common.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;

public class CustomObjectMapper extends ObjectMapper {
    private static final long serialVersionUID = 1L;

    public CustomObjectMapper(){

        super();
        DefaultSerializerProvider.Impl sp = new DefaultSerializerProvider.Impl();
        sp.setNullValueSerializer(new NullSerializer());
        this.setSerializerProvider(sp);
    }
}
