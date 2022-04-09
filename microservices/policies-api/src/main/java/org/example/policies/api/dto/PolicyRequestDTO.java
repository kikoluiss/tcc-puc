package org.example.policies.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyRequestDTO {
    private String id;
    private Long insuranceId;
    private List<Long> peopleIds;
}
