package com.example.MistralAI.Controller;


import com.example.MistralAI.Models.ChatModels;
import com.example.MistralAI.Services.ChatModelService;
import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mistral-ai")
@CrossOrigin("*")
public class ChatController {

    private final MistralAiChatModel chatModel;
    private final ChatModelService chatService;

    public ChatController(MistralAiChatModel chatModel,ChatModelService chatService) {
        this.chatModel = chatModel;
        this.chatService = chatService;

    }
    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {
        String response = chatModel.call(message);

        ChatModels chatModels=new ChatModels(message,response);
        chatService.saveMessages(chatModels);

        return ResponseEntity.ok(response);

    }

    public ResponseEntity<List<ChatModels>> getChatHistory(){
        return ResponseEntity.ok(chatService.getAllMessages());
    }
    }

