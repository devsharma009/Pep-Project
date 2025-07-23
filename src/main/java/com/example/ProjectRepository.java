package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
} 