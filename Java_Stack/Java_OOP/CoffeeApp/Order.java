package Java_OOP.CoffeeApp;

import java.util.ArrayList;

public class Order {

    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<>();

    public Order(String name) {
        this.items = new ArrayList<>();
        this.name = name;
        this.ready = false;
    }

    public Order() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        getItems().add(item);

    }

    public void getStatusMessage() {
        if (isReady()) {
            System.out.println("Your order is ready");
        } else {
            System.out.println("Thank you for waiting. Your order will be ready soon.");
        }
    }

    public double getOrderTotal() {
        double total = 0.0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice();

        }
        return total;
    }

    public void displayMenu() {

        System.out.println("-- " + name + "'s order --");

        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + " " + items.get(i).getName() + " -- $" + items.get(i).getPrice());
        }
        System.out.println("-- Total: $" + getOrderTotal() + " --");

    }
}
