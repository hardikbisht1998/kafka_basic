package com.example.learnKafka.user_service.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Value("${kafka.topic.user-random-topic}")
    private String TOPIC_NAME;

    @Value("${kafka.topic.user-created-topic}")
    private String TOPIC_USER_CREATED;

    @Bean
    public NewTopic userRandomTopic(){
        return new NewTopic(TOPIC_NAME,3,(short)1);
    }

    @Bean
    public NewTopic userCreatedTopic(){
        return new NewTopic(TOPIC_USER_CREATED,3,(short)1);
    }


}
