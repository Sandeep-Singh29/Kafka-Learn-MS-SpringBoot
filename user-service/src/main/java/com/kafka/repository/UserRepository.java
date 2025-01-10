package com.kafka.repository;

import com.kafka.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: SANDEEP
 * Date: 10/01/25
 */

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
