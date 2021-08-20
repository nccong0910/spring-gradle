package com.example.springgradle.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CachingService {

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
    @Cacheable(cacheNames = "cacheName")
    public String cacheTest(){
        simulateSlowService();
        log.info("Returning NOT from cache!");
        return "here";
    }
}
