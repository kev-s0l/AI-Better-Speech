package com.betterspeech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betterspeech.exception.ResourceNotFoundException;
import com.betterspeech.model.Prompt;
import com.betterspeech.repository.PromptRepository;

@Service
public class PromptServices {

   private final PromptRepository promptRepository;

   public PromptServices(PromptRepository promptRepository){
    this.promptRepository = promptRepository;
   }    

   public List<Prompt> getAllPrompts(){
    return promptRepository.findAll();
   }

   public Prompt getPromptbyID(Long id){
    return promptRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Prompt not found: " + id));
   }

   public Prompt createPrompt(Prompt prompt){
    return promptRepository.save(prompt);
   }

   public void deletePrompt(Long id){
      if (!promptRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found: " + id);
        }
    promptRepository.deleteById(id);
   }
    


}
