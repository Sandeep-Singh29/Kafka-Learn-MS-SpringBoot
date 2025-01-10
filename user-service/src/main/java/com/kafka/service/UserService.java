package com.kafka.service;

import com.kafka.dto.UserDTO;

/**
 * Author: SANDEEP
 * Date: 10/01/25
 */

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

}
