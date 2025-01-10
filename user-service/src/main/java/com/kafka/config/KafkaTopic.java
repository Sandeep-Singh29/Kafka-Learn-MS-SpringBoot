package com.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Author: SANDEEP
 * Date: 09/01/25
 */

@Configuration
public class KafkaTopic {

    @Value("${kafka.topic.name}")
    private String NORMAL_TOPIC;

    @Value("${kafka.user.topic.name}")
    private String USER_TOPIC;

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name(NORMAL_TOPIC)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic userCreatedTopic() {
        return TopicBuilder.name(USER_TOPIC)
                .partitions(2)
                .replicas(1)
                .build();
    }

}
