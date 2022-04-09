package org.example.providers.api.dto;

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
public class CoverageDTO {
    private Long id;
    private String description;
    private Double price;
    private List<ShortageDTO> shortages;
}
