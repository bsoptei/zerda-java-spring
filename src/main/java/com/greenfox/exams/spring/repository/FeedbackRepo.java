package com.greenfox.exams.spring.repository;

import com.greenfox.exams.spring.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback, Long> {
}
