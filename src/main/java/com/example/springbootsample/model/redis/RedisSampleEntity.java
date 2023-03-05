package com.example.springbootsample.model.redis;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.data.redis.core.RedisHash;
//
//@RedisHash("Redis-sample")
@AllArgsConstructor
@Getter
@Setter
public class RedisSampleEntity {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
}
