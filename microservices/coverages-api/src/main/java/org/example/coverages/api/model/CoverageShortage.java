package org.example.coverages.api.model;

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
@Table(name = "coverages_shortages")
@IdClass(CoverageShortageCompositeKey.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoverageShortage {

    @Id
    @JsonProperty("coverage_id")
    private Long coverageId;

    @Id
    @JsonProperty("shortage_id")
    private Long shortageId;

}
