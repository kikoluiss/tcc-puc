package org.com.exams.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExamDTO {
    private String id;
    private Long assuredPersonId;
    private Long providerPersonId;
    private Long providerCompanyId;
    private CoverageDTO coverage;
    private GeolocationDTO geolocation;
}
