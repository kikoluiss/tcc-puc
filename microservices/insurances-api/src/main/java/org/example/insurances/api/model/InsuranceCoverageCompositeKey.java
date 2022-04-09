package org.example.insurances.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceCoverageCompositeKey implements Serializable {
    private Long insuranceId;
    private Long coverageId;
}
