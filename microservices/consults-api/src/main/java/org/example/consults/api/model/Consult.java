package org.example.consults.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.consults.api.dto.CoverageDTO;
import org.example.consults.api.dto.GeolocationDTO;
import org.example.consults.api.dto.SpecialtyDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Document(collection = "consults")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consult {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("assured_person_id")
    private Long assuredPersonId;

    @JsonProperty("provider_person_id")
    private Long providerPersonId;

    @JsonProperty("provider_ompany_id")
    private Long providerCompanyId;

    @JsonProperty("coverage")
    private CoverageDTO coverage;

    @JsonProperty("specialty")
    private SpecialtyDTO specialty;

    @JsonProperty("geolocation")
    private GeolocationDTO geolocation;

    @JsonProperty("protocol")
    private String protocol;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

}
