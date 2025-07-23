package com.example;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String assignedTo; // For simplicity, can be changed to relation later
} 