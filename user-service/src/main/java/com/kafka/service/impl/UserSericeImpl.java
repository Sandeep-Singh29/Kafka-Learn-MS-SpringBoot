package com.kafka.service.impl;

import com.kafka.dto.UserDTO;
import com.kafka.entity.User;
import com.kafka.event.UserCreateEvent;
import com.kafka.repository.UserRepository;
import com.kafka.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Author: SANDEEP
 * Date: 10/01/25
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class UserSericeImpl implements UserService {

    @Value("${kafka.user.topic.name}")
    private String USER_TOPIC;

    private final UserRepository userRepository;
    private final KafkaTemplate<String, UserCreateEvent> kafkaTemplate;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        log.info("User Event Data in UserSericeImpl :: {}", userDTO.toString());
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        User createUser = userRepository.save(user);
        userDTO.setId(createUser.getId());
        log.info("User is Save Successfully in DB :: {}", createUser);

        // Set Data into UserEvent
        UserCreateEvent event = new UserCreateEvent();
        event.setId(user.getId());
        event.setName(user.getName());
        event.setEmail(user.getEmail());
        log.info("Kafka Producer Send a User :: {}", event);
        kafkaTemplate.send(USER_TOPIC, event.getId(), event);
        return userDTO;
    }
}
