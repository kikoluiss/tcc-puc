package org.example.consults.api.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.consults.api.client.CoveragesClient;
import org.example.consults.api.client.SpecialtiesClient;
import org.example.consults.api.dto.ConsultDTO;
import org.example.consults.api.dto.ConsultAuthorizeDTO;
import org.example.consults.api.dto.ConsultRegisterDTO;
import org.example.consults.api.model.Consult;
import org.example.consults.api.repository.ConsultRepository;
import org.example.consults.api.service.ConsultService;
import org.example.consults.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ConsultServiceImpl implements ConsultService {

    @Autowired
    private ConsultRepository repository;

    @Autowired
    private CoveragesClient coveragesClient;

    @Autowired
    private SpecialtiesClient specialtiesClient;

    @Override
    public ConsultDTO findById(String id) {
        Optional<Consult> optional = repository.findById(id);
        if (optional.isPresent()) {
            Consult consult = optional.get();

            return getConsultDTO(consult);
        }
        return null;
    }

    @Override
    public String authorize(ConsultAuthorizeDTO consultAuthorizeDTO) {
        String token = createToken();
        log.info("Generated Token: " + token);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Boolean isValid = isValidateToken(token);
        log.info("Validated Token: " + isValid);
        return token;
    }

    @Override
    public ConsultDTO register(ConsultRegisterDTO consultRegisterDTO) {
        Consult consult = getConsult(consultRegisterDTO);
        consult.setId(null);
        consult.setCreatedAt(Date.valueOf(LocalDate.now()));
        consult.setUpdatedAt(Date.valueOf(LocalDate.now()));
        return getConsultDTO(repository.save(consult));
    }

    @Override
    public Boolean isValidateToken(String token) {
        String data = new String(Base64.getDecoder().decode(token.getBytes(StandardCharsets.UTF_8)));
        String[] splittedData = data.split(":");
        LocalDateTime tokenDate = LocalDateTime.ofEpochSecond(
                Long.parseLong(splittedData[0]), 0, ZoneOffset.UTC
        );
        LocalDateTime checkDate = LocalDateTime.now().minusHours(3);
        return tokenDate.isAfter(checkDate);
    }

    private ConsultDTO getConsultDTO(Consult consult) {
        ConsultDTO consultDTO = ModelMapperSingleton.get().map(consult, ConsultDTO.class);

        return consultDTO;
    }

    private Consult getConsult(ConsultRegisterDTO consultRegisterDTO) {
        Consult consult = ModelMapperSingleton.get().map(consultRegisterDTO, Consult.class);

        consult.setCoverage(coveragesClient.get(consultRegisterDTO.getCoverageId()));
        consult.setSpecialty(specialtiesClient.get(consultRegisterDTO.getSpecialtyId()));

        return consult;
    }

    private String createToken() {
        String time = String.valueOf(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        String uuid = UUID.randomUUID().toString();
        return Base64.getEncoder().encodeToString(
                String.format("%s:%s", time, uuid)
                        .getBytes(StandardCharsets.UTF_8)
        );
    }
}
