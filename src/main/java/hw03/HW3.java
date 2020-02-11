package hw03;

import java.util.Scanner;

public class HW3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] schedule;
        //массив день/задание
        schedule = new String[][]{{"Monday", "Go to courses"},
                {"Tuesday","Do your diploma"},
                {"Wednesday","Play football"},
                {"Thursday","Do homework"},
                {"Friday","Meet with your friends"},
                {"Saturday","Go to gym"},
                {"Sunday","Chill"}};
        System.out.print("Please input the day of the week: ");
        String userInput = in.nextLine().toLowerCase();

        while(!userInput.equals("exit")){
            switch (userInput){
                case "monday":
                    System.out.printf("Your task for %s: %s\n", schedule[0][0], schedule[0][1]);
                    break;
                case "tuesday":
                    System.out.printf("Your task for %s: %s\n", schedule[1][0], schedule[1][1]);
                    break;
                case "wednesday":
                    System.out.printf("Your task for %s: %s\n", schedule[2][0], schedule[2][1]);
                    break;
                case "thursday":
                    System.out.printf("Your task for %s: %s\n", schedule[3][0], schedule[3][1]);
                    break;
                case "friday":
                    System.out.printf("Your task for %s: %s\n", schedule[4][0], schedule[4][1]);
                    break;
                case "saturday":
                    System.out.printf("Your task for %s: %s\n", schedule[5][0], schedule[5][1]);
                case "sunday":
                    System.out.printf("Your task for %s: %s\n", schedule[6][0], schedule[6][1]);
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
                    break;
            }
            userInput = in.nextLine().toLowerCase();
        }
    }
}
