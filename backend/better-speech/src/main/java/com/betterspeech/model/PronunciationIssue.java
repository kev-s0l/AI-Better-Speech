package com.betterspeech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pronunciation_issue")
@Getter
@Setter
public class PronunciationIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The issue belongs to one attempt. This side holds the foreign key (attempt_id).
    @ManyToOne(optional = false)
    @JoinColumn(name = "attempt_id")
    private Attempts attempt;

    // Which word in the prompt had the problem (e.g. the 3rd word)
    private int wordIndex;

    // The word that was supposed to be said
    @Column(nullable = false)
    private String expectedWord;

    // What the user actually said / the engine heard
    private String heardWord;

    // Optional phoneme-level detail, e.g. expected "æ" but got "ɑ"
    private String expectedPhoneme;
    private String heardPhoneme;

    // Confidence/severity of the mistake, 0.0 - 1.0
    private double severity;
}