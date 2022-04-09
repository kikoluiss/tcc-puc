package org.example.consults.api.service;

import org.example.consults.api.dto.ConsultDTO;
import org.example.consults.api.dto.ConsultAuthorizeDTO;
import org.example.consults.api.dto.ConsultRegisterDTO;

public interface ConsultService {
    ConsultDTO findById(String id);
    String authorize(ConsultAuthorizeDTO consultAuthorizeDTO);
    ConsultDTO register(ConsultRegisterDTO consultRegisterDTO);
    Boolean isValidateToken(String token);
}
