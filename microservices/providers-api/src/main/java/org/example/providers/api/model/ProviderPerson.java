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
@Table(name = "providers_people")
@IdClass(ProviderPersonCompositeKey.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderPerson {

    @Id
    @JsonProperty("provider_id")
    private Long providerId;

    @Id
    @JsonProperty("person_id")
    private Long personId;

}
