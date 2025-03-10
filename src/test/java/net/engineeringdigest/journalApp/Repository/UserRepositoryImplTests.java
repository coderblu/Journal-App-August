package net.engineeringdigest.journalApp.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTests {
    @Autowired
    private UserRepositoryImpl userRepository;
    @Test
    public void TestSaveNewUser()
    {
        Assertions.assertNotNull(userRepository.getUserForSA());
    }
}
