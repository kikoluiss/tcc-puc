package org.example.insurances.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "insurances_coverages")
@IdClass(InsuranceCoverageCompositeKey.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceCoverage {

    @Id
    @JsonProperty("insurance_id")
    private Long insuranceId;

    @Id
    @JsonProperty("coverage_id")
    private Long coverageId;

}
