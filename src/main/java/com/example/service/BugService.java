package com.example.service;

import com.example.Bug;
import java.util.List;

public interface BugService {
    Bug createBug(Bug bug);
    Bug updateBug(Long id, Bug bug);
    void deleteBug(Long id);
    Bug getBugById(Long id);
    List<Bug> getAllBugs();
} 