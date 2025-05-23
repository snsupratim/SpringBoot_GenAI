package com.example.MistralAI.Repository;

import com.example.MistralAI.Models.ChatModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatModelRepository extends JpaRepository<ChatModels,Long> {

}
