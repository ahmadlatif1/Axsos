package Java_fundamentals.Hashmatique;

import java.util.HashMap;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String,String> trackList= new HashMap<String,String>();
        trackList.put("HashBrowns","life's a menu full of hashbrowns");
        trackList.put("BashSounds","it started getting worrying");
        trackList.put("CashMounds","hell yeah");
        trackList.put("SlushFund","yes please");

        System.out.println(trackList.get("HashBrowns"));

        for (String key : trackList.keySet()){
            System.out.printf("%s : %s%n",key,trackList.get(key));
        }






    }
}
