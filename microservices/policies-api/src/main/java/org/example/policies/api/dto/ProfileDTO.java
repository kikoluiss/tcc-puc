package org.example.policies.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
    private Long id;
    private CategoryDTO category;
    private LocaleDTO locale;
    private SpecialtyDTO specialty;
    private String fullName;
    private Integer age;
    private String gender;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String postalCode;
    private String phoneNumber;
}
