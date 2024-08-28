package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private UserRepository userRepository;


//    @GetMapping()
//    public ResponseEntity<?> getAll() {
//        List<User> allEntries = userService.getAll();
//        if(allEntries !=null && !allEntries.isEmpty())
//        {
//            return new ResponseEntity<>(allEntries,HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }



    @GetMapping("/id/{myId}")
    public ResponseEntity<User> getJournalEntryById(@PathVariable ObjectId myId) {
        Optional<User> user = userService.findById(myId);
        if (user.isPresent()) {
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteUserById(@PathVariable ObjectId myId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    public ResponseEntity<?> updateJournalById( @RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
        if (userInDb != null) {
          userInDb.setUserName(user.getUserName());
          userInDb.setPassword(user.getPassword());
          userService.saveNewUser(userInDb);
            return new ResponseEntity<>(userInDb,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
