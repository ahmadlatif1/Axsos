package Java_fundamentals.JavaCafe;

import java.util.ArrayList;

public class CafeUtil {

    static int getStreakGoal(int weeks){
        int sum = 0;
        for (int i=0;i<weeks;i++){
            sum+=i;
        }
        return sum;
    }

    static double getOrderTotal(double[] prices){
        double total=0;
        for (double num :prices) total+=num;
        return total;
    }

    static void displayMenu(ArrayList<String> menu){
        for (int i=0;i<menu.size();i++){
            System.out.printf("%s %s%n",i,menu.get(i));
        }
    }

    static void addCustomer(ArrayList<String> customers){
        System.out.println("HELLO, please enter your name:");
        String username=System.console().readLine();
        System.out.println("Hello, "+username);
        System.out.printf("there are %s customers infront of you. %n", customers.size());
        customers.add(username);

    }

}
