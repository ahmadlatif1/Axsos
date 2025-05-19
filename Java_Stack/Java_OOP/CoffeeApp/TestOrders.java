package Java_OOP.CoffeeApp;

public class TestOrders {

    public static void main(String[] args) {

        CoffeKiosk shop=new CoffeKiosk();

        shop.addMenuItem("cappuccino", 15);
        shop.addMenuItem("latte", 12);
        shop.addMenuItem("americano", 10);
        shop.addMenuItem("chai latte", 12);
        shop.addMenuItem("espresso", 10);
        shop.addMenuItem("turkish coffee", 12);

        shop.displayMenu();
        shop.newOrder();
        
    }
}
