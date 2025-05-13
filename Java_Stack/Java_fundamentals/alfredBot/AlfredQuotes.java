package Java_fundamentals.alfredBot;

import java.util.Date;

public class AlfredQuotes {

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello, %s, lovely to see you.".formatted(name);
    }

    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date=new Date();
        return "it is currently %s".formatted(date);
    }

    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if (conversation.contains("Alexis"))return "Right away, sir. She certainly isn't sophisticated enough for that.";
        if (conversation.contains("Alfred"))return "At your service, as you wish, naturally.";
        return "Right, and with that i shall retire.";

    }

    // NINJA BONUS
    // See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}