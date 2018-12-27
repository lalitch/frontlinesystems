package com.plessentials.frontlinesystems.controllers;

import com.plessentials.frontlinesystems.dataproviders.DynamoDBDataProvider;
import com.plessentials.frontlinesystems.dataproviders.IDataProvider;
import com.plessentials.frontlinesystems.models.User;
import com.plessentials.frontlinesystems.utils.Validations;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private IDataProvider<User> userDataProvider;

    public UsersController() {
        this.userDataProvider = new DynamoDBDataProvider<>(User.class);
    }

    @PostMapping()
    public User addUser(@RequestBody User user) {
        Validations.validateUser(user);
        user.generateIdIfMissing();
        this.userDataProvider.save(user);

        return user;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return this.userDataProvider.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        User user = new User(id);
        this.userDataProvider.delete(user);
    }
}

