package org.example.providers.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDTO {
    private Long id;
    private String description;
    private List<CoverageDTO> coverages;
    private List<PersonDTO> people;
}
