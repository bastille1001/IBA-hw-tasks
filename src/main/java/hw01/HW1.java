package hw01;
import java.util.Arrays;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        //генерация случайных чисел [0-100]
        int randomNum = (int) (Math.random() * (100 + 1));
        Scanner in = new Scanner(System.in);
        //массив чисел, который буду заполнять
        int[] array = new int[100];
        //использовал просто для проверки кода
        System.out.println(randomNum);
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
                System.out.println("Congratulations, " + name + "!");
                break;
            }
        }
        //пузырьковый метод сортировки
        for (int k = 0; k < array.length - 1; k++) {
            for (int j = k + 1; j < array.length; j++) {
                if (array[k] < array[j]) {
                    int m = array[j];
                    array[j] = array[k];
                    array[k] = m;
                }
            }
        }
        String aString = Arrays.toString(array);
        // вывод на экран введенных чисел
        System.out.println("Your numbers is: " + aString);
    }
}

