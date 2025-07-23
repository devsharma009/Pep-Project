package com.example;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String username; // Unique username as primary key
    @Column(unique = true, nullable = false)
    private String email;
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, DEVELOPER, TESTER
    }
}