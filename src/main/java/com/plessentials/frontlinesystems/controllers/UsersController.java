package com.plessentials.frontlinesystems.controllers;

import com.plessentials.frontlinesystems.dataproviders.DynamoDBDataProvider;
import com.plessentials.frontlinesystems.dataproviders.IDataProvider;
import com.plessentials.frontlinesystems.models.User;
import com.plessentials.frontlinesystems.utils.Validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private IDataProvider<User> usersDataProvider;

    @Autowired
    public UsersController(IDataProvider<User> usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
    }

    @PostMapping()
    public User addUser(@RequestBody User user) {
        Validations.validateUser(user);
        user.generateIdIfMissing();
        this.usersDataProvider.save(user);

        return user;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return this.usersDataProvider.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        User user = new User(id);
        this.usersDataProvider.delete(user);
    }
}

