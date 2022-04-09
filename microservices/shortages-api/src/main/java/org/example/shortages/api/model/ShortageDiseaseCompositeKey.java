package org.example.shortages.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortageDiseaseCompositeKey implements Serializable {
    private Long shortageId;
    private Long diseaseId;
}
