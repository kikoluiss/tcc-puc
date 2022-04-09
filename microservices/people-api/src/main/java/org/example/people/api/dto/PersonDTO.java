package org.example.people.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private ProfileDTO profile;
    private Long holderId;
    private String ownershipType;
    private String policyId;
}
