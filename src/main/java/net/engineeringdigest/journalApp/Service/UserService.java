package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.Repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void saveEntry(User user)
    {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
