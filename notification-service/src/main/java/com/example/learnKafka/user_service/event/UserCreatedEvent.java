package com.example.learnKafka.user_service.event;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserCreatedEvent {
    private Long id;
    private String name;
    private String email;


    @Override
    public String toString() {
        return "UserCreatedEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
