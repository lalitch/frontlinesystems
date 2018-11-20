package com.plessentials.frontlinesystems.controllers;

import com.plessentials.frontlinesystems.models.User;
import com.plessentials.frontlinesystems.utils.RestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class TestController {
    @GetMapping("/test")
    public User test() {
        RestClient<User> restClient = new RestClient<User>(User.class);
        return restClient.get(URI.create("https://putsreq.com/kow1qydD9w4HiQjkNTzl"));
    }

    @GetMapping("/welcome")
    public String test1() {
        return "Welcome User";
    }
}
