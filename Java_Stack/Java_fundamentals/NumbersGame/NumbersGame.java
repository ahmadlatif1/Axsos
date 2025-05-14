package Java_fundamentals.NumbersGame;

import java.util.Random;
public class NumbersGame {
    public static void main(String[] args){
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");
        System.out.println("Can you guess the number?");
        System.out.println("If you are not up to the task, you can always type 'q' to quit.");
        int answer = new Random().nextInt(0,10);
        int attempts=2;
        while(true){


            String guess = System.console().readLine();

            if(guess.equals("q")){
                System.out.println("I knew you didn't have it in you.");
                System.out.println("Shutting down...");
                break;
            }
            if (guess.length()>1){
                System.out.println("try not to talk much.");
                break;
            }
            if (!guess.toLowerCase().equals(guess.toUpperCase())){
                System.out.println("that is not a number.");
                break;
            }
            if(Integer.parseInt(guess)==answer){
                System.out.println("Lucky guess! But can you do it again?\n");
                answer=new Random().nextInt(0,10);

            }else{
                if (attempts==0){
                    System.out.println("You failed, but maybe you can try again!");
                    attempts=2;
                    answer=new Random().nextInt(0,10);

                }
                else{

                    System.out.println("Swing and a miss! "+attempts+" attempts remaining.");
                    attempts-=1;

                }
            }
        }
        System.out.println("Game over. Shutting down...");
    }
}