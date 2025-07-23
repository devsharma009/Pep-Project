package com.example.service;

import com.example.Project;
import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    Project updateProject(Long id, Project project);
    void deleteProject(Long id);
    Project getProjectById(Long id);
    List<Project> getAllProjects();
} 