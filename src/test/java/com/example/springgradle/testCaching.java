package com.example.springgradle;

import com.example.springgradle.services.CachingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ExtendWith(SpringExtension.class)
@SpringBootTest("spring.cache.type=simple")
@Slf4j
public class testCaching {

    @Autowired
    private CachingService service;

    private static final Logger logger = LoggerFactory.getLogger(testCaching.class);

    @Test
    public void testCaching(){
        String firstString = service.cacheTest();
        logger.info("First {}", firstString);

        String secondString = service.cacheTest();
        logger.info("Second {}", secondString);
    }
}
