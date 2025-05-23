package com.example.MistralAI.Services;

import com.example.MistralAI.Models.ChatModels;
import com.example.MistralAI.Repository.ChatModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatModelService {
    private final ChatModelRepository chatModelRepository;

    public ChatModelService(ChatModelRepository chatModelRepository){
        this.chatModelRepository=chatModelRepository;
    }

    public ChatModels saveMessages(ChatModels message){
        return chatModelRepository.save(message);
    }

    public List<ChatModels> getAllMessages(){
        return chatModelRepository.findAll();
    }

}
