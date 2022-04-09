package org.com.exams.api.service;

import org.com.exams.api.dto.ExamDTO;
import org.com.exams.api.dto.ExamRequestDTO;

public interface ExamService {
    ExamDTO findById(String id);
    ExamDTO register(ExamRequestDTO examRequestDTO);
}
