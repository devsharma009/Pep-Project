package com.example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.Bug;
import com.example.BugRepository;
import com.example.ProjectRepository;
import com.example.UserRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bugs")
public class BugController {
    @Autowired
    private BugRepository bugRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Bug> createBug(@RequestBody Bug bug) {
        // Optionally, validate relatedProject and assignedTo here
        Bug savedBug = bugRepository.save(bug);
        return ResponseEntity.ok(savedBug);
    }

    @GetMapping
    public List<Bug> getAllBugs() {
        return bugRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bug> getBugById(@PathVariable Long id) {
        Optional<Bug> bug = bugRepository.findById(id);
        return bug.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bug> updateBug(@PathVariable Long id, @RequestBody Bug updatedBug) {
        return bugRepository.findById(id)
            .map(bug -> {
                bug.setTitle(updatedBug.getTitle());
                bug.setDescription(updatedBug.getDescription());
                bug.setSeverity(updatedBug.getSeverity());
                bug.setStatus(updatedBug.getStatus());
                bug.setRelatedProject(updatedBug.getRelatedProject());
                bug.setAssignedTo(updatedBug.getAssignedTo());
                bugRepository.save(bug);
                return ResponseEntity.ok(bug);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBug(@PathVariable Long id) {
        if (bugRepository.existsById(id)) {
            bugRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 