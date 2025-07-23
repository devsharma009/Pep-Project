package com.example;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bugs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String severity;
    private String status;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project relatedProject;
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;
} 