package com.example.Routing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/daikichi")
public class daikichiController {
    @RequestMapping("")
    public String index(){
        return "Welcome";
    }

    @RequestMapping("/today")
    public String today(){
        return "Today you will find luck in "+ new String[]{"one", "some", "NONE"}[new Random().nextInt(3)]+" of your endeavors";
    }

    @RequestMapping("/tomorrow")
    public String tomorrow(){
        return "tomorrow, new opportunities will "+ new String[]{"arise", "vanish", "come from an unexpected place","not come, or the day after, or after, you may have been struck by a curse?"," maybe appear, or not, who's to say?","definitely come, you should believe everything you read on the internet"}[new Random().nextInt(6)]+", so be open to new ideas.";
    }
}
