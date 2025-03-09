package dev.ferv.courier_service.infrastructure.adapter;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import dev.ferv.courier_service.domain.port.RedisStoragePort;

@Component
public class RedisStorageAdapter implements RedisStoragePort{

    private final RedisTemplate<String, String> redisTemplate;

    public RedisStorageAdapter(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void saveCode(String phoneNumber, String code, long ttlMinutes) {
        redisTemplate.opsForValue().set(phoneNumber, code, ttlMinutes, TimeUnit.MINUTES);
    }

    @Override
    public String getCode(String phoneNumber) {
        return redisTemplate.opsForValue().get(phoneNumber);
    }

    @Override
    public void deleteCode(String phoneNumber) {
        redisTemplate.delete(phoneNumber);
    }

}
