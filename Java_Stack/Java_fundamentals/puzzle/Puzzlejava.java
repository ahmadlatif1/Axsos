package Java_fundamentals.puzzle;

import java.util.Arrays;
import java.util.Random;

public class Puzzlejava     {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getTenRolls()));

        System.out.println(getRandomLetter());

        System.out.println(generatePassword());

        String[] arr=getNewPasswordSet(10);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(shuffle(arr)));


    }
    static int[] getTenRolls (){
        Random rand=new Random();
        int[] arr=new int[10];
        for (int i = 0; i < arr.length; i++) {

            arr[i]=rand.nextInt(0,21);

        }
        return arr;
    }
    static char getRandomLetter(){



        return "abcdefghijklmnopqrstuvwxyz".charAt(new Random().nextInt(0,26));
    }
    static String generatePassword(){
        String result="";
        for (int i = 0; i < 8; i++) {
            result=result+getRandomLetter();
        }
        return result;
    }
    static String[] getNewPasswordSet(int num){
        String[] result=new String[num];
        for (int i = 0; i < num; i++) {
            result[i]=generatePassword();
        }
        return result;

    }
    static Object[] shuffle(Object[] arr){

        Random rand= new Random();
        for (int i = 0; i <arr.length ; i++) {

            for (int j = 0; j < 3; j++) {
                Object tmp=arr[i];
                int r=rand.nextInt(0,arr.length);
                arr[i]=arr[r];
                arr[r]=tmp;
            }

        }

        return arr;
    }
}
