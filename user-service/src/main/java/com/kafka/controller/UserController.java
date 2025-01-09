package com.kafka.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: SANDEEP
 * Date: 09/01/25
 */

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewTopic topic;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
//       /*
       for(int i=0;i<5000;i++){
            kafkaTemplate.send(topic.name(), message+" : "+i);
        }
//        */
//        kafkaTemplate.send(topic.name(), message);
        log.info("Message Send Successfully To :: {}", topic.name());
        return ResponseEntity.ok("Message Queued");
    }

}
