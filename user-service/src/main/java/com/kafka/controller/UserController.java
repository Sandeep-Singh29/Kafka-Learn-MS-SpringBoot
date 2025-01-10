package com.kafka.controller;

import com.kafka.dto.UserDTO;
import com.kafka.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    private final UserService userService;

    @Value("${kafka.topic.name}")
    private String NORMAL_TOPIC;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
       /*
       for(int i=0;i<5000;i++){
            kafkaTemplate.send(topic.name(), message+" : "+i);
        }
        */
        kafkaTemplate.send(NORMAL_TOPIC, message);
        log.info("Message Send Successfully To :: {}", NORMAL_TOPIC);
        return ResponseEntity.ok("Message Queued");
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDTO userDTO) {
        log.info("Producer Event Data in UserController {}", userDTO.toString());
        UserDTO user = userService.createUser(userDTO);
        Map<String, Object> map = new HashMap<>();
        map.put("userData", user);
        map.put("statusMessage", "Message Queued Successfully...!!");
        return ResponseEntity.ok(map);
    }

}
