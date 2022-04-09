package org.com.exams.api.converter;

import org.springframework.core.convert.converter.Converter;

import java.sql.Date;

public class SqlDateWriteConverter implements Converter<Date, Date> {
    @Override
    public Date convert(Date source) {
        Date javaDate = null;
        if (source != null) {
            javaDate = Date.valueOf(source.toLocalDate());
        }
        return javaDate;
    }
}
