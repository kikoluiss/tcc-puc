package org.example.coverages.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoverageDTO {
    private Long id;
    private String description;
    private Double price;
    private String authorizationType;
    private List<ShortageDTO> shortages;
}
