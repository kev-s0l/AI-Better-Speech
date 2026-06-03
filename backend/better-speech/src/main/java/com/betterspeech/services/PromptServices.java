package com.betterspeech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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

   public Optional<Prompt> getPromptbyID(Long id){
    return promptRepository.findById(id);
   }

   public Prompt createPrompt(Prompt prompt){
    return promptRepository.save(prompt);
   }

   public void deletePrompt(Long id){
    promptRepository.deleteById(id);
   }
    


}
