package com.example.springgradle.democaching;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames={"user"})
public class UserService {

    @Cacheable
    public User findUserById(int id) {
        simulateSlowService();
        return new User(id, "Any name");
    }
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
    @CacheEvict
    public void clearCacheById(int id) {
    }
    @CacheEvict(allEntries = true)
    public void clearCache() {
    }
    @CachePut
    public User reloadAndFindUserById(int id) {
        simulateSlowService();
        return new User(id, "reload Any name");
    }
}
