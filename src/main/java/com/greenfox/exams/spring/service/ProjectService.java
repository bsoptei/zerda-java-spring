package com.greenfox.exams.spring.service;

import com.greenfox.exams.spring.domain.Project;
import com.greenfox.exams.spring.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private ProjectRepo projectRepo;

    @Autowired
    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public List<Project> obtainAllProjects(){
        return projectRepo.findAll();
    }
}
