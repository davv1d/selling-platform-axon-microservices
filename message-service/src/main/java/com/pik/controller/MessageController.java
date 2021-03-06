package com.pik.controller;

import com.pik.domain.Message;
import com.pik.domain.dto.MessageDto;
import com.pik.repository.ChatMessageRepository;
import com.pik.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MessageController {
    private final MessageService messageService;
    private final ChatMessageRepository chatMessageRepository;

    @PostMapping("/")
    public CompletableFuture<String> sendMessage(@RequestBody MessageDto messageDto) {
        return messageService.sendMessage(messageDto);
    }

    @GetMapping("/{recipientId}")
    public List<Message> get(@PathVariable String recipientId) {
        return chatMessageRepository.findByRecipientId(recipientId);
    }
}
