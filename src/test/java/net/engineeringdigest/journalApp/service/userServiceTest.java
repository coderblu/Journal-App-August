package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class userServiceTest {
    @Autowired
    private UserRepository userRepository;


    @ParameterizedTest
    @ValueSource(strings = {"ram",
            "shyam",
            "vpul"})
    public void testFIndByUserName(String name) {
        userRepository.findByUserName("ram");
//        assertEquals(4,2+1);
        assertNotNull(userRepository.findByUserName("ram"));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,3",
            "2,2,10"}
    )
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }
}
