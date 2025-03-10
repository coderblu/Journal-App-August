package net.engineeringdigest.journalApp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplatep;

    @Test
    @Disabled
    void testSendMail()
    {
        redisTemplatep.opsForValue().set("email","xyz.gmail.com");
        Object email = redisTemplatep.opsForValue().get("email");
        Object name = redisTemplatep.opsForValue().get("name");
        Object salary = redisTemplatep.opsForValue().get("salary");
        int a = 1;
    }
}
