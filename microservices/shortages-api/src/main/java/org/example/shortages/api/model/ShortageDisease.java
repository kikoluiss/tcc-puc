package org.example.shortages.api.model;

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
@Table(name = "shortages_diseases")
@IdClass(ShortageDiseaseCompositeKey.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortageDisease {

    @Id
    @JsonProperty("shortage_id")
    private Long shortageId;

    @Id
    @JsonProperty("disease_id")
    private Long diseaseId;

}
