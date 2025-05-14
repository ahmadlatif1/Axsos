package Java_fundamentals.exceptions;

import java.util.ArrayList;

public class exceptions {

    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        try {
            for(int i = 0; i < myList.size(); i++) {
                Integer castedValue = (Integer) myList.get(i);
            }
        } catch (Exception e) {
            System.out.println("cant cast, figure it out  \n "+e);

        }


    }
}
