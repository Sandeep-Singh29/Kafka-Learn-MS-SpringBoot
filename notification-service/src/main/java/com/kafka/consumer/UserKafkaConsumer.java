package com.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Author: SANDEEP
 * Date: 09/01/25
 */

@Service
@Slf4j
public class UserKafkaConsumer {

    @Value("${kafka.topic.name}")
    private String topicName;

    @KafkaListener(topics = "${kafka.topic.name}"/*, groupId = "${spring.application.name}"*/)
    public void consumerMessage1(String message) {
        log.info("Message Consume into consumerMessage1() with Topic :: {} {} {}", topicName, " Message is :: ", message);
    }

    @KafkaListener(topics = "${kafka.topic.name}"/*, groupId = "${spring.application.name}"*/)
    public void consumerMessage2(String message) {
        log.info("Message Consume into consumerMessage2() with Topic :: {} {} {}", topicName, " Message is :: ", message);
    }

    @KafkaListener(topics = "${kafka.topic.name}"/*, groupId = "${spring.application.name}"*/)
    public void consumerMessage3(String message) {
        log.info("Message Consume into consumerMessage3() with Topic :: {} {} {}", topicName, " Message is :: ", message);
    }


}
