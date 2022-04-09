package org.example.consults.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultAuthorizeDTO {
    private String id;
    private Long assuredPersonId;
    private Long providerPersonId;
    private Long providerCompanyId;
    private Long coverageId;
    private Long specialtyId;
}
