package com.betterspeech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prompt")
@Getter
@Setter
public class Prompt {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;

    @Column(nullable=false,length=1000)
    private String text;

    @Column(nullable=false)
    private int difficulty = 1;
}
