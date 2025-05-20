package Java_OOP.ZooKeeper;

import java.util.Random;

public class Gorilla extends Mammal {

    public Gorilla() {
    }

    public void throwSomething(){

        System.out.println("a Gorilla just threw a "+ new String[]{"Banana Peel","Clump of Mud","Flower Bouquet","Bag of Shrimp","Chocolate Arrangement","Hurtful Insult","Unscheduled Meeting"}[new Random().nextInt(7)]+" at a passerby!");
        setEnergy(getEnergy()-5);
    }
    public void eatBanana(){

        System.out.println("Gorilla eat banana");
        setEnergy(getEnergy()+10);
    }
    public void climb(){

        System.out.println("Gorilla climb");
        setEnergy(getEnergy()-10);
    }
}
