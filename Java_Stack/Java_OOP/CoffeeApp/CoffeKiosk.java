package Java_OOP.CoffeeApp;

import java.util.ArrayList;

public class CoffeKiosk{
    private ArrayList<Item> menu=new ArrayList<Item>();
    private ArrayList<Order> orders=new ArrayList<Order>();
   
    public CoffeKiosk(){

    }

    public void addMenuItem(String name ,double price){

        menu.add(new Item(name,price));


    }

    public void displayMenu(){

        for (int i = 0; i < menu.size(); i++){
        System.out.println(i+" "+menu.get(i).getName()+" -- $"+ menu.get(i).getPrice());
        }
    }

    public void newOrder() {
        
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        orders.add(new Order(name));
    
        System.out.println("Please enter a menu item index or q to quit:");

        
        String itemNumber = System.console().readLine();

        
        while(!itemNumber.equals("q")) {
        
            orders.get(orders.size()-1).addItem(menu.get(Integer.parseInt(itemNumber)));
            itemNumber=System.console().readLine();    

                
        }
        
        orders.get(orders.size()-1).displayMenu();
    }

    public ArrayList<Item> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Item> menu) {
        this.menu = menu;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
    



}