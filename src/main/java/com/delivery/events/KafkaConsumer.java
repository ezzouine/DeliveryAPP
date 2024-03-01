package com.delivery.events;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "delivery-app-topic", groupId = "group-id")
    public void listen(String message) {
        System.out.println("new delivery detail ctreated : " + message);
    }
}
