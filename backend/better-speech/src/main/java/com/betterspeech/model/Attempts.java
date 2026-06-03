package com.betterspeech.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "attempts")
@Getter
@Setter

public class Attempts {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional=false)
    @JoinColumn(name = "prompt_id")
    private Prompt prompt;

    @Column(nullable=false)
    private double overallScore;
    
    @Column(length = 2000)
    private String transcript;
    
    private String audioUrl;

    @Column(nullable = false)
    private Instant createdAt = Instant.now();

    @OneToMany(mappedBy = "attempt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PronunciationIssue> issues = new ArrayList<>();
}
