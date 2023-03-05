//package com.example.springbootsample.controller;
//
//
//import com.example.springbootsample.model.redis.RedisSampleEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//import java.util.concurrent.TimeUnit;
//
//@RestController
//@RequestMapping("/redis-tests")
//public class RedisController {
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @PostMapping("/insert")
//    public void save(RedisSampleEntity redisSampleEntity){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set(redisSampleEntity.getId(), TimeUnit.SECONDS);
//    }
//
//    @GetMapping("find-by-id")
//    public RedisSampleEntity findById(Long id){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        return (RedisSampleEntity) valueOperations.get(id);
//    }
//
//    @DeleteMapping("/delete")
//    public void delete(Long key){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.getOperations().delete(key);
//    }
//}
