package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Value("${data.api.key}")
    private String apiKey;
    @Autowired
    private UserService userService;
    @GetMapping("/health-check")
    public String healthCheck()
    {
        return apiKey;
    }
    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
            try {
                userService.saveNewUser(user);
                return new ResponseEntity<User>(user, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<User>> getAllUsers()
    {
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }
}
