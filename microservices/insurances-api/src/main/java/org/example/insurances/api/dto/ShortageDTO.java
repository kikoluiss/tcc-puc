package org.example.insurances.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortageDTO {
    private Long id;
    private AgeGroupDTO ageGroup;
    private String description;
    private Integer waitingMonths;
    private List<DiseaseDTO> diseases;
}
