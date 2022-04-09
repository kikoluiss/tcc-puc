package org.example.people.api.util;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

public class ModelMapperSingleton {

    private static ModelMapper mapper;

    private ModelMapperSingleton() {
    }

    public static ModelMapper get() {
        if (mapper == null) {
            mapper = new ModelMapper();
            mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        }
        return mapper;
    }
}
