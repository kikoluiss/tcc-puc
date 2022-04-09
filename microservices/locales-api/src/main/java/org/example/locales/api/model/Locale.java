package org.example.locales.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "locales")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Locale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("state_abbreviation")
    private String stateAbbreviation;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("central_latitude")
    private Double centralLatitude;

    @JsonProperty("central_longitude")
    private Double centralLongitude;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

}
