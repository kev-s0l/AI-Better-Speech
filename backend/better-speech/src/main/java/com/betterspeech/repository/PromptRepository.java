package com.betterspeech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betterspeech.model.Prompt;



public interface PromptRepository extends JpaRepository<Prompt, Long> {
}
