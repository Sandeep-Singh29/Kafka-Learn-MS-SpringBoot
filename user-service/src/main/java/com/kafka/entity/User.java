package com.kafka.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

/**
 * Author: SANDEEP
 * Date: 10/01/25
 */

@Entity
@Table
@Data
public class User {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(columnDefinition = "CHAR(36)", unique = true)
    private String id;
    private String name;
    private String email;


}
