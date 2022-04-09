package org.com.exams.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.exams.api.dto.CoverageDTO;
import org.com.exams.api.dto.GeolocationDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Document(collection = "exams")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exam {

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

    @JsonProperty("geolocation")
    private GeolocationDTO geolocation;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

}
