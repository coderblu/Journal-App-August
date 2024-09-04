package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.Service.UserDetailsServiceImpl;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDetailsServiceImplTests {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Mock
    private UserRepository userRepository;

    void loadUserByUserNameTest()
    {
//when(userRepository.findByUserName()).thenReturn()
    }
}
