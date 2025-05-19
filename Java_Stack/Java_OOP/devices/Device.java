package Java_OOP.devices;

public class Device {
    private int battery=100;

    public Device() {

    }

    public String status (){
        return battery+"%\n";
    }

    public int getBattery() {
        return battery;
    }

    public void loseCharge(int amount){
        setBattery(getBattery()-amount);
    }

    public void addCharge(int amount){
        setBattery(getBattery()+amount);
    }

    public void setBattery(int battery) {
        if (battery>100)battery=100;
        else if (battery<0)battery=0;
        else this.battery = battery;
    }
}
