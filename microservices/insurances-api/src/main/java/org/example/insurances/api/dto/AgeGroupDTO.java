package org.example.insurances.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgeGroupDTO {
    private Long id;
    private String description;
    private Integer initialAge;
    private Integer finalAge;
}
