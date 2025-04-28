package com.example.learnKafka.user_service.controller;

import com.example.learnKafka.user_service.dto.CreateUserRequestDto;
import com.example.learnKafka.user_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")

public class UserController {

    @Autowired
    private  KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private UserService userService;

    @Value("${kafka.topic.user-random-topic}")
    private String TOPIC_NAME;

    @PostMapping("/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message){
        kafkaTemplate.send(TOPIC_NAME,message);
        return ResponseEntity.ok("Mesage queued");
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        userService.createUser(createUserRequestDto);
        System.out.println("controller: "+createUserRequestDto);
        return ResponseEntity.ok("NEW User Created");
    }

}
