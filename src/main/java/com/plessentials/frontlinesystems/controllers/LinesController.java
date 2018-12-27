package com.plessentials.frontlinesystems.controllers;

import com.plessentials.frontlinesystems.cacheproviders.AvailableNumbersCacheProvider;
import com.plessentials.frontlinesystems.dataproviders.DynamoDBDataProvider;
import com.plessentials.frontlinesystems.dataproviders.IDataProvider;
import com.plessentials.frontlinesystems.models.Line;
import com.plessentials.frontlinesystems.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController()
public class LinesController {
    private AvailableNumbersCacheProvider availableNumbersCacheProvider;
    private IDataProvider<User> usersDataProvider;

    public LinesController() {
        this.availableNumbersCacheProvider = new AvailableNumbersCacheProvider();
        this.usersDataProvider = new DynamoDBDataProvider<>(User.class);
    }

    @PostMapping("users/{userId}/lines")
    public Line addLine(@PathVariable String userId, @RequestBody Line line)
    {
        var user = this.usersDataProvider.get(userId);
        var availablenumber = this.availableNumbersCacheProvider.getAvailableNumber();
        line.setNumber(availablenumber);

        if(user.getLines() != null)
        {
            user.getLines().add(line);
        }
        else
        {
            var lines = new ArrayList<Line>();
            lines.add(line);

            user.setLines(lines);
        }

        this.usersDataProvider.save(user);

        return line;
    }

    @DeleteMapping("users/{userId}/lines/{number}")
    public void deleteLine(@PathVariable String userId, @PathVariable String number) {
        User user = this.usersDataProvider.get(userId);
        int index = this.getLineIndex(user, number);

        var lines = user.getLines();
        lines.remove(index);

        this.usersDataProvider.save(user);
    }

    private int getLineIndex(User user, String number)
    {
        var lines = user.getLines();
        for(int i = 0; i < lines.size(); i++)
        {
            if(lines.get(i).getNumber().equals(number))
            {
                return i;
            }
        }

        return -1;
    }
}
