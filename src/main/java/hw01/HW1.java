package hw01;
import java.util.Arrays;
import java.util.Scanner;

public class HW1 {


    public static int[] addElement(int[] org, int added) {
        int[] result = Arrays.copyOf(org, org.length + 1);
        result[org.length] = added;
        return result;
    }


    public static void main(String[] args) {
        int pos = 0;

        int randomNum = (int) (Math.random() * (100 + 1));
        Scanner in = new Scanner(System.in);


        int[] array = new int[100];


        System.out.print("Enter your name: ");
        String name = in.nextLine();
        System.out.println("Let the game begin!");


        for (int i = 0; i < array.length; i++) {
            int guessNum = in.nextInt();
            array[i] = guessNum;
            if (randomNum < guessNum) {
                System.out.println("Your number is too big. Please, try again.");
            } else if (randomNum > guessNum) {
                System.out.println("Your number is too small. Please, try again.");
            } else {
                System.out.printf("Congratulations, %s! \n",name);
                for (int k = 0; k < array.length - 1 ; k++) {
                    for (int j = k + 1; j < array.length; j++) {
                        if (array[k] < array[j]) {
                            int m = array[j];
                            array[j] = array[k];
                            array[k] = m;
                        }
                    }
                }
                System.out.println("Your number is:");
                int[] a1 = Arrays.copyOf(array,i);
                System.out.println(Arrays.toString(addElement(a1,array[i])));
                break;
            }
        }
    }
}

