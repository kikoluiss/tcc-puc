package org.com.exams.api.util;

import org.modelmapper.ModelMapper;

public class ModelMapperSingleton {

    private static ModelMapper mapper;

    private ModelMapperSingleton() {
    }

    public static ModelMapper get() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }
}
