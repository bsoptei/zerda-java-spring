package com.greenfox.exams.spring;

import com.greenfox.exams.spring.domain.Project;
import com.greenfox.exams.spring.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProjectRepo repo;

    @Autowired
    public DataLoader(ProjectRepo repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... strings) throws Exception {
        repo.save(new Project("Clash of Zerda", "android"));
        repo.save(new Project("Clash of Zerda", "spring"));
        repo.save(new Project("Zerda Reader", "android"));
        repo.save(new Project("Zerda Reader", "spring"));
        repo.save(new Project("Konnekt Contact Manager", "spring"));
    }
}