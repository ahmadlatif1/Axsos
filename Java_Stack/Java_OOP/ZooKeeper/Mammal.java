package Java_OOP.ZooKeeper;

public class Mammal {
    private int energy = 100;

    public Mammal() {
    }

    public Mammal(int energy) {
        this.energy = energy;

    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if(energy>100) this.energy=100; else
        if (energy<0) this.energy=0; else
        this.energy=energy;
    }
}
