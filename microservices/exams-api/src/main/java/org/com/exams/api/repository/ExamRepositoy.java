package org.com.exams.api.repository;

import org.com.exams.api.model.Exam;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamRepositoy extends MongoRepository<Exam, String> {

}
