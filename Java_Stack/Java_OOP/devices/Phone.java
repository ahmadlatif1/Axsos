package Java_OOP.devices;

public class Phone extends Device{

    public Phone() {
    }


    @Override
    public String status() {
        if (getBattery()<10)
            return super.status()+"Battery low! charge now.\n";
        return super.status();
    }

    public void makeCall(){
        System.out.println("calling...");
        System.out.println(". . . (talking noises) . . .");
        loseCharge(15);
        System.out.println("call finished, charge is at "+status());
    }

    public void playGame(){
        System.out.println("opening game...");
        if (getBattery()<25){
            System.out.println("after seeing the charge ("+getBattery()+"%), you decide to not play this time.\n");
            return;
        }
        System.out.println(". . . (random clicking) . . .");
        loseCharge(20);
        System.out.println("game closed, charge is at"+status());
    }

    public void charge(){
        System.out.println("plugging in...");
        System.out.println(". . . (electronics zapping) . . .");
        addCharge(50);
        System.out.println("after 20 minutes, charge is at"+status());
    }

}
