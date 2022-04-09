package org.example.shortages.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "shortages")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shortage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("age_group_id")
    private Long ageGroupId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("waiting_months")
    private Integer waitingMonths;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

}
