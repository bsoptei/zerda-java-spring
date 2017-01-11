package com.greenfox.exams.spring.repository;

import com.greenfox.exams.spring.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}
