package org.com.exams.api.service.impl;

import org.com.exams.api.client.CoveragesClient;
import org.com.exams.api.dto.ExamDTO;
import org.com.exams.api.dto.ExamRequestDTO;
import org.com.exams.api.model.Exam;
import org.com.exams.api.repository.ExamRepositoy;
import org.com.exams.api.service.ExamService;
import org.com.exams.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepositoy repository;

    @Autowired
    private CoveragesClient coveragesClient;

    @Override
    public ExamDTO findById(String id) {
        Optional<Exam> optional = repository.findById(id);
        if (optional.isPresent()) {
            Exam exam = optional.get();

            return getExamDTO(exam);
        }
        return null;
    }

    @Override
    public ExamDTO register(ExamRequestDTO examRequestDTO) {
        Exam exam = getExam(examRequestDTO);
        exam.setId(null);
        exam.setCreatedAt(Date.valueOf(LocalDate.now()));
        exam.setUpdatedAt(Date.valueOf(LocalDate.now()));
        return getExamDTO(repository.save(exam));
    }

    private ExamDTO getExamDTO(Exam exam) {
        ExamDTO examDTO = ModelMapperSingleton.get().map(exam, ExamDTO.class);

        return examDTO;
    }

    private Exam getExam(ExamRequestDTO examRequestDTO) {
        Exam exam = ModelMapperSingleton.get().map(examRequestDTO, Exam.class);

        exam.setCoverage(coveragesClient.get(examRequestDTO.getCoverageId()));

        return exam;
    }

}
