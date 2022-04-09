package org.example.consults.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultDTO {
    private String id;
    private Long assuredPersonId;
    private Long providerPersonId;
    private Long providerCompanyId;
    private CoverageDTO coverage;
    private SpecialtyDTO specialty;
    private GeolocationDTO geolocation;
    private String protocol;
}
