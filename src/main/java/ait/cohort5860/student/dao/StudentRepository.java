package ait.cohort5860.student.dao;

import ait.cohort5860.student.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.stream.Stream;

public interface StudentRepository extends MongoRepository<Student, Long> {
    Stream<Student> findByNameIgnoreCase(String name);

    @Query("{'scores.Math': {'$gt': 90}}")
    Stream<Student> findByExamAndScoreGreaterThan(String examName, Integer score);
}
