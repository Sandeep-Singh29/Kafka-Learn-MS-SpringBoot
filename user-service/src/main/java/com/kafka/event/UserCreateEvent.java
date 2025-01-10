package com.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Author: SANDEEP
 * Date: 10/01/25
 */

@Data
@RequiredArgsConstructor
public class UserCreateEvent {

    private String id;
    private String name;
    private String email;


}
