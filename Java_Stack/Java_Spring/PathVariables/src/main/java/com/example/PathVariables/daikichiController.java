package com.example.PathVariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/daichiki")
public class daikichiController {
    @RequestMapping("/travel/{spot}")
    public String travel(@PathVariable("spot") String location){
        return "Congratulations! You will travel to "+location;
    }

    @RequestMapping("/lotto/{num}")
    public String lotto(@PathVariable("num") int num){

        String[] happenings={
                "you wil take a grand journey in the future, be wary of tempting offers",
                "You have enjoyed the fruits of your labor but now it is the time to spend with family and friends",
                "Go Straight to Prison, Do Not Pass GO, Do Not Collect 200$",
                "you will be visited by the tax man",
                "one day, you will be visited by a stranger who makes extraordinary claims, believe it or not, they're not lying at all, it really is the lost prince of Nicaragua who will usher in a new age of prosperity",
                "the immortal snail, your mortal enemy! comes closer. only "+new Random().nextInt(20,2000000)+" meters away from your location now.",
                "Do Not Trust That Old Man",
                "some time in the next two months, you will swallow a spider in your sleep",
                "The Ant King has come back for vengeance of all you've taken from the Ant kingdom!, intentionally or not; approximately "+new Random(2).nextInt(2000,900000)+" lives have been mourned, You will stand as you are to face your crimes! uh, "+(new Random(2).nextInt(2000,900000)+1)+" now, how will you- oh, "+(new Random(2).nextInt(2000,900000)+3)+", please stop."
        };
        return happenings[new Random(num).nextInt(0,happenings.length)];
    }
}
