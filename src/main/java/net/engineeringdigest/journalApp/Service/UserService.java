package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.Repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public void saveEntry(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("User"));
        userRepository.save(user);
    }

    public List<User> getAll()
    {
        return userRepository.findAll();
    }
    public Optional<User> findById(ObjectId myId)
    {
        return userRepository.findById(myId);
    }
    public void deleteById(ObjectId myId)
    {
        userRepository.deleteById(myId);
    }

    public User findByUserName(String username)
    {
        return userRepository.findByUserName(username);
    }
}
