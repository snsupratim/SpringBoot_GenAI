package com.example.MistralAI.Models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mistralai")
public class ChatModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String userMessage;
    @Column(columnDefinition = "TEXT")
    private String botResponse;
    private LocalDateTime timestamp;

    public ChatModels(){
        this.timestamp=LocalDateTime.now();
    }

    public ChatModels(String userMessage, String botResponse){
        this.userMessage=userMessage;
        this.botResponse=botResponse;
        this.timestamp=LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getBotResponse() {
        return botResponse;
    }

    public void setBotResponse(String botResponse) {
        this.botResponse = botResponse;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
