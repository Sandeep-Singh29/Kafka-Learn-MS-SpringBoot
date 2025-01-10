package com.kafka.notification;

import com.kafka.event.UserCreateEvent;
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
    private String NORMAL_TOPIC;

    @Value("${kafka.user.topic.name}")
    private String USER_TOPIC;

    @KafkaListener(topics = "${kafka.topic.name}"/*, groupId = "${spring.application.name}"*/)
    public void consumerMessage1(String message) {
        log.info("Message Consume into consumerMessage1() with Topic :: {} {} {}", NORMAL_TOPIC, " Message is :: ", message);
    }

    @KafkaListener(topics = "${kafka.topic.name}"/*, groupId = "${spring.application.name}"*/)
    public void consumerMessage2(String message) {
        log.info("Message Consume into consumerMessage2() with Topic :: {} {} {}", NORMAL_TOPIC, " Message is :: ", message);
    }

    @KafkaListener(topics = "${kafka.topic.name}"/*, groupId = "${spring.application.name}"*/)
    public void consumerMessage3(String message) {
        log.info("Message Consume into consumerMessage3() with Topic :: {} {} {}", NORMAL_TOPIC, " Message is :: ", message);
    }

    @KafkaListener(topics = "${kafka.user.topic.name}", groupId = "${spring.application.name}")
    public void UserConsumer(UserCreateEvent event) {
        log.info("User Event Consume into UserConsumer() with Topic :: {} {} {}", USER_TOPIC, "User Event Date", event.toString());
    }


}
