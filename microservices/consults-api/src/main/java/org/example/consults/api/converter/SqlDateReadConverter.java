package org.example.consults.api.converter;

import org.springframework.core.convert.converter.Converter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class SqlDateReadConverter implements Converter<java.util.Date, Date> {
    @Override
    public Date convert(java.util.Date source) {
        Date sqlDate = null;
        if (source != null) {
            sqlDate = Date.valueOf(LocalDate.ofInstant(source.toInstant(), ZoneId.systemDefault()));
        }
        return sqlDate;
    }
}