package com.example.learnKafka.notification_service.consumer;



import com.example.learnKafka.user_service.event.UserCreatedEvent;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
@Data
public class UserKafkaConsumer {

//    @Value("${kafka.topic.user-random-topic}")
//    private  String TOPIC_NAME;

    @KafkaListener(topics = "User-created-topic")
    public void handleUserCreated(UserCreatedEvent userCreatedEvent){
        System.out.println("handle user created {}"+userCreatedEvent);
    }

    @KafkaListener(topics = "User-random-topic")
    public void handleUserRandomTopic(String msg){
//       log.info(msg);
        System.out.println("recieved mssg in 1:"+msg);
    }

    @KafkaListener(topics = "User-random-topic")
    public void handleUserRandomTopic2(String msg){
//       log.info(msg);
        System.out.println("recieved mssg in 2:"+msg);
    }

    @KafkaListener(topics = "User-random-topic")
    public void handleUserRandomTopic3(String msg){
//       log.info(msg);
        System.out.println("recieved mssg in 3:"+msg);
    }

}
