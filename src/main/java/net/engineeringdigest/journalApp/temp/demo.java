package net.engineeringdigest.journalApp.temp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



public class demo {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Value("${weather.api.key}")
    public static String demo;
    public static void main(String[] args) {
        System.out.println(demo);
        }
}
