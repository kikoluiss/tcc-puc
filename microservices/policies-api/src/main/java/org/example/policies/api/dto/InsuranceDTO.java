package org.example.policies.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceDTO {
    private Long id;
    private String description;
    private Double coParticipationPercent;
    private Date validUntil;
    private String status;
    private List<CoverageDTO> coverages;
}
