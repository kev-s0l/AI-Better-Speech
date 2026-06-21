package com.betterspeech.dto;

import java.time.Instant;
import com.betterspeech.model.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private final Long id;
    private final String username;
    private final String email;
    private final Instant createdAt;


    public UserResponse(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.createdAt = user.getCreatedAt();
    }
}
