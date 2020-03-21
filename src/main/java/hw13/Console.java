package hw13;

import hw13.dao.FamilyController;
import hw13.family.Human;
import hw13.family.HumanBuilder;
import hw13.family.Man;
import hw13.family.Woman;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    public void console()throws ParseException{
        FamilyController familyController = new FamilyController();
        while (true){
            message(listOfCommand());
            switch (inputId("Enter the command")){
                case 1:
                    familyController.createFamilies(10);
                    message("Test data created");
                    break;
                case 2:
                    familyController.displayAllFamilies();
                    break;
                case 3:
                    familyController.getFamiliesBiggerThan(inputId("Enter number of member: "));
                    break;
                case 4:
                    familyController.getFamiliesLessThan(inputId("Enter number of member: "));
                    break;
                case 5:
                    System.out.println(familyController.countFamiliesWithMemberNumber
                            (inputId("Enter number of people in family: ")));
                    break;
                case 6:
                    try {
                        familyController.createNewFamily(dataAboutFather(), dataAboutMother());
                    } catch (Exception ex) {
                        message("Incorrect input");
                    }
                    break;
                case 7:
                    familyController.deleteFamilyByIndex(inputId("Enter family Id to delete"));
                    break;
                case 8:
                    int c = inputId("Enter next command.\n'1' - born child\n'2' - adopt child\n'3' - back to menu\n");
                    switch (c) {
                        case 1:
                            try {
                                familyController.bornChild(inputId("Enter family id"),
                                        inputString("Enter name for boy "),
                                        inputString("Enter name for girl "));
                            } catch (NullPointerException ex) {
                                message("Wrong family index");
                            }
                            break;
                        case 2:
                            try {
                                familyController.adoptChild(inputId("Enter family id "), dataAboutChild());
                            } catch (NullPointerException ex) {
                                message("Wrong family index");
                            }
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 9:
                    int ageFilter = inputId("Enter age filter");
                    familyController.deleteAllChildrenOlderThen(ageFilter);
                    break;
                case -1:
                    message("Incorrect input");
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

    private static Man dataAboutFather() throws ParseException {
        HumanBuilder hb = new HumanBuilder();
        Scanner in = new Scanner(System.in);
        message("Please, enter info about father\n");
        message("Enter name: ");
        String name = in.nextLine();
        message("Enter surname: ");
        String surname = in.nextLine();
        message("Enter birth Date in format (dd/MM/yyyy): ");
        String birthDate = in.nextLine();
        message("Enter Iq: ");
        int iq = in.nextInt();
        return new Man(name, surname, birthDate, iq);
    }

    private static Woman dataAboutMother() throws ParseException {
        HumanBuilder hb = new HumanBuilder();
        Scanner in = new Scanner(System.in);
        message("Please, enter info about mother\n");
        message("Enter name: ");
        String name = in.nextLine();
        message("Enter surname: ");
        String surname = in.nextLine();
        message("Enter birth Date in format (dd/MM/yyyy): ");
        String birthDate = in.nextLine();
        message("Enter Iq: ");
        int iq = in.nextInt();
        return new Woman(name, surname, birthDate, iq);
    }

    private static Human dataAboutChild() throws ParseException {
        HumanBuilder hb = new HumanBuilder();
        Scanner in = new Scanner(System.in);
        message("Please, enter info about child ");
        message("Enter name: ");
        String name = in.nextLine();
        message("Enter surname: ");
        String surname = in.nextLine();
        message("Enter birth Date in format (dd/MM/yyyy): ");
        String birthDate = in.nextLine();
        return new Human(name, surname, birthDate);
    }

    private static int inputId(String s) {
        Scanner in = new Scanner(System.in);
        message(s);
        try {
            return in.nextInt();
        } catch (InputMismatchException ex) {
            return -1;
        }
    }


    private static String listOfCommand() {
        final StringBuilder sb = new StringBuilder("Main\n");
        sb.append("1 - Fill with test data\n");
        sb.append("2 - Display the entire list of families\n");
        sb.append("3 - Display a list of families where the number of people is greater than the specified number\n");
        sb.append("4 - Display a list of families where the number of people is less than the specified number\n");
        sb.append("5 - Calculate the number of families where the number of members is \n");
        sb.append("6 - Create a new family\n");
        sb.append("7 - Delete a family by its index in the general list\n");
        sb.append("8 - Edit a family by its index in the general list\n");
        sb.append("9 - Remove all children over the age of majority\n");
        sb.append("0 - Exit\n");
        return sb.toString();
    }


    private static void message(String s) {
        System.out.println(s);
    }

    private static String inputString(String s) {
        Scanner in = new Scanner(System.in);
        message(s);
        return in.nextLine();
    }
}
