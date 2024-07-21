package com.example.demo.Interface;

public interface IRedisService  {
    void saveData(String key, Object value);
    <T> T getData(String key, Class<T> clazz);
    void deleteData(String key);
    void setKeyExpiration(String key, long timeout);

}
