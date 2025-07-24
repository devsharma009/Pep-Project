package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Bug;

public interface BugRepository extends JpaRepository<Bug, Long> {
} 