package org.example.policies.api.config;

import org.example.policies.api.converter.SqlDateReadConverter;
import org.example.policies.api.converter.SqlDateWriteConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

    @Override
    protected String getDatabaseName() {
        return "boa_saude";
    }

    @Override
    public MongoCustomConversions customConversions() {
        converters.add(new SqlDateReadConverter());
        converters.add(new SqlDateWriteConverter());
        return new MongoCustomConversions(converters);
    }

}
