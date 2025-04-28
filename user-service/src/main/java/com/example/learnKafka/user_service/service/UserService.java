package com.example.learnKafka.user_service.service;

import com.example.learnKafka.user_service.dto.CreateUserRequestDto;
import com.example.learnKafka.user_service.entity.User;
import com.example.learnKafka.user_service.event.UserCreatedEvent;
import com.example.learnKafka.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value("${kafka.topic.user-created-topic}")
    private String TOPIC_USER_CREATED;

   @Autowired
    private  UserRepository userRepository;

   @Autowired
    private  ModelMapper modelMapper;

   @Autowired
    private  KafkaTemplate<Long, UserCreatedEvent> kafkaTemplate;

    public void createUser(CreateUserRequestDto createUserRequestDto) {
        User user=modelMapper.map(createUserRequestDto,User.class);
        User savedUser=userRepository.save(user);
        System.out.println("saved user :"+user);
        UserCreatedEvent userCreatedEvent=modelMapper.map(savedUser, UserCreatedEvent.class);

        System.out.println(userCreatedEvent);
        kafkaTemplate.send(TOPIC_USER_CREATED,userCreatedEvent.getId(),userCreatedEvent);


    }
}
