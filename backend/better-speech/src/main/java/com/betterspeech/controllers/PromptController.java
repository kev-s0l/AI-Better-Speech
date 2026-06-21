package com.betterspeech.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betterspeech.model.Prompt;
import com.betterspeech.services.PromptServices;

@RestController
@RequestMapping("/api/prompts")
public class PromptController {
    
    private final PromptServices promptService;

    public PromptController(PromptServices promptService){
    this.promptService = promptService;
    }

    @GetMapping
    public List<Prompt> getAllPrompts() {
        return promptService.getAllPrompts();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Prompt> getPromptById(@PathVariable Long id){
        Prompt prompt = promptService.getPromptbyID(id);
        return ResponseEntity.ok(prompt);
    }

    @PostMapping
    public ResponseEntity<Prompt> createPrompt(@RequestBody Prompt prompt){
        Prompt saved = promptService.createPrompt(prompt);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
