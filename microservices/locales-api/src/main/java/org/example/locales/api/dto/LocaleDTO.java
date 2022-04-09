package org.example.locales.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocaleDTO {
    private Long id;
    private String cityName;
    private String stateAbbreviation;
    private String countryCode;
    private Double centralLatitude;
    private Double centralLongitude;
}
