package com.kafka.event;

import lombok.Data;

/**
 * Author: SANDEEP
 * Date: 10/01/25
 */
@Data
public class UserCreateEvent {

    private String id;
    private String name;
    private String email;

}
