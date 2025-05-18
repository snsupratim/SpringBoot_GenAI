package com.example.MistralAI;


import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mistralai")
@CrossOrigin("*")
public class MistralController {
    private MistralAiChatModel chatModel;

    public MistralController(MistralAiChatModel chatModel){
        this.chatModel=chatModel;
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getResponse(@PathVariable String message){
        String response=chatModel.call(message);
        return ResponseEntity.ok(response);
    }

}
