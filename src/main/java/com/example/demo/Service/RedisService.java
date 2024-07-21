package com.example.demo.Service;

import com.example.demo.Interface.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService implements IRedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    public void saveData(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }
    public <T> T getData(String key, Class<T> clazz) {
        Object value = redisTemplate.opsForValue().get(key);
        return clazz.cast(value);
    }

    @Override
    public void deleteData(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void setKeyExpiration(String key, long timeout) {
        redisTemplate.expire(key, timeout, TimeUnit.HOURS);
    }
}
