package com.twitterclone.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/create-test-user")
    public String createUser() {
        // 2. Create a new user object
        User newUser = new User("chen_yu", "chen@upm.es", "Building a Twitter clone");

        // 3. THIS is where the autocomplete works!
        // When you type userRepository. here, save() will appear.
        userRepository.save(newUser);

        return "User saved to PostgreSQL successfully!";
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}