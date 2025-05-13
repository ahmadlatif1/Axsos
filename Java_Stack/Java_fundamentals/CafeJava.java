package Java_fundamentals;

import java.util.ArrayList;

public class CafeJava {

    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app.
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 2.0;
        double latte = 3.0;
        double cappuccino = 4.0;

        Item[] items= {
            new Item("mocha",3.5),
            new Item("dripCoffee",2.0),
            new Item("latte",3.0),
            new Item("cappuccino",4.0)
        };

        // Customer name variables (add yours below)
        Customer Shatha=new Customer("Shatha");
        Customer Ahmad=new Customer("Ahmad");
        Customer Sali=new Customer("Sali");
        Customer Adam=new Customer("Adam");
        Customer[] customers={Shatha,Ahmad,Sali,Adam};


        // Order completions (add yours below)
        boolean isReadyOrder1 = false;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        for (Customer customer : customers){
            System.out.println(generalGreeting + customer.name); // Displays "Welcome to Cafe Java, Shatha"
        }
        // ** Your customer interaction print statements will go here ** //
        // ORDERS HERE

        Sali.order(items[1]);
        Ahmad.order(items[3]);
        Sali.order(items[2]);
        Sali.order(items[2]);



        for (Customer customer : customers) {

            double total=0;
            if (!customer.orders.isEmpty()) {
                System.out.println("ORDER:");
                while (!customer.orders.isEmpty()) {
                    Item tmp = customer.getOrder();
                    total += tmp.price;
                    System.out.printf("%s's order of %s is ready %n", customer.name, tmp.name);
                }
                System.out.printf("Hello %s, your total will be %s$ %n%n", customer.name, total);
            }


        }
        // orders have been processed
        System.out.printf("\nAdam owes %s$",(items[2].price-items[1].price));

        items[2].price=2.0;
        System.out.printf("\nNevermind, Adam owes %s$ now!",(items[2].price-items[1].price));



    }


}
class Customer{
     String name;
     ArrayList<Item> orders;


    public Customer(String name) {
        this.name = name;
        orders=new ArrayList<Item>();
    }
    void order(Item order){
        orders.add(order);
        System.out.printf("Your order of %s is being processed, %s. it will cost [%s$] please hold%n", order.name,this.name, order.price);
    }
    Item getOrder(){
        return orders.removeFirst();
    }

}
class Item{
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}