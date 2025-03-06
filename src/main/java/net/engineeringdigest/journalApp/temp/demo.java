package net.engineeringdigest.journalApp.temp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



public class demo {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public static void main(String[] args) {

        String rawPassword = "Ram";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println(passwordEncoder.matches(rawPassword, encodedPassword));
        encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println(passwordEncoder.matches(rawPassword, encodedPassword));
        encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println(passwordEncoder.matches(rawPassword, encodedPassword));
        System.err.println(passwordEncoder.encode("Ram"));
        encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println(passwordEncoder.matches(rawPassword, encodedPassword));
        encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println(passwordEncoder.matches(rawPassword, encodedPassword));

        System.out.println(passwordEncoder.matches(rawPassword, encodedPassword));
        System.out.println(passwordEncoder.matches(rawPassword, encodedPassword));
        System.out.println(passwordEncoder.matches(rawPassword, encodedPassword));
        System.err.println(passwordEncoder.encode("Ram"));
        System.err.println(passwordEncoder.encode("Ram"));
        System.err.println(passwordEncoder.encode("Ram"));
    }
}
