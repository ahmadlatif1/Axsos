package Java_OOP.ZooKeeper;

public class Bat extends Mammal {
    public Bat() {
        setEnergy(300);
    }

    public void fly(){
        System.out.println("Mysterious squeeking noises appear around the park at night.");
        setEnergy(getEnergy()-20);
    }

    public void attackTown(){
        System.out.println("Town is under siege! the army seems.. to have disappeared into a cloud of bats.");
        setEnergy(getEnergy()-100);
    }

    public void eatHuman(){
        System.out.println("A town resident arrived at the hospital, reporting a small bite that appeared overnight.");
        setEnergy(getEnergy()+100);
    }
}
