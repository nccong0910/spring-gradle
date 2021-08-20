package com.example.springgradle;

import com.example.springgradle.democaching.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CachingUserTest {
    private static final Logger logger = LoggerFactory.getLogger(CachingUserTest.class);

    @Autowired
    private UserService service;

    @Test
    public void cachingUserTest(){
        logger.info("------------------ demo @Cacheable --------------------");
        logger.info("find user with id = 1: {}", service.findUserById(1));
        logger.info("find user with id = 1: {}", service.findUserById(1));
        logger.info("find user with id = 2: {}", service.findUserById(2));
        logger.info("find user with id = 2: {}", service.findUserById(2));
        logger.info("------------------ demo @CacheEvict --------------------");
        service.clearCache();
        logger.info("find user with id = 1: {}", service.findUserById(1));
        logger.info("find user with id = 2: {}", service.findUserById(2));
        logger.info("------------------ demo @CachePut --------------------");
        logger.info("reload and find user with id = 1: {}", service.reloadAndFindUserById(1));
        logger.info("find user with id = 1: {}", service.findUserById(1));
        logger.info("find user with id = 2: {}", service.findUserById(2));
    }
}
