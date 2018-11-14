package com.plessentials.frontlinesystems.controllers;

import com.plessentials.frontlinesystems.dataproviders.DataProvider;
import com.plessentials.frontlinesystems.models.User;
import com.plessentials.frontlinesystems.utils.Validations;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {
    private DataProvider<User> userDataProvider;

    public UsersController() {
        this.userDataProvider = new DataProvider<>();
    }

    @PostMapping()
    public User addUser(@RequestBody User user) {
        Validations.validateUser(user);

        user.setId(UUID.randomUUID().toString());
        this.userDataProvider.save(user);

        return user;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return this.userDataProvider.get(User.class, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        User user = new User();
        user.setId(id);

        this.userDataProvider.delete(user);
    }
}
