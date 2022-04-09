package org.example.providers.api.model;

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
@Table(name = "providers_coverages")
@IdClass(ProviderCoverageCompositeKey.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderCoverage {

    @Id
    @JsonProperty("provider_id")
    private Long providerId;

    @Id
    @JsonProperty("coverage_id")
    private Long coverageId;

}
