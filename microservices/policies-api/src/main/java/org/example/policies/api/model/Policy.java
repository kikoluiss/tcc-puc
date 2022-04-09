package org.example.policies.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.policies.api.dto.InsuranceDTO;
import org.example.policies.api.dto.PersonDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.List;

@Document(collection = "policies")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("insurance")
    private InsuranceDTO insurance;

    @JsonProperty("people")
    private List<PersonDTO> people;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

}
