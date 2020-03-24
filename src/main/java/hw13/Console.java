package hw13;

import hw13.dao.Controller.FamilyController;
import hw13.family.Human;
import hw13.family.HumanBuilder;
import hw13.family.Man;
import hw13.family.Woman;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console  {

    private String path =  "family_data.bin";
    SaveLoader saveLoader = new SaveLoader(path);

    public void console() throws ParseException, FileNotFoundException {
        FamilyController fc = new FamilyController();
        while (true) {
            message(listOfCommand());
            switch (inputId("Enter the command")) {
                case 1:
                    fc.createFamilies(10);
                    message("Test data created");
                    break;
                case 2:
                    fc.displayAllFamilies();
                    break;
                case 3:
                    fc.getFamiliesBiggerThan(inputId("Enter number of member: "));
                    break;
                case 4:
                    fc.getFamiliesLessThan(inputId("Enter number of member: "));
                    break;
                case 5:
                    System.out.println(fc.countFamiliesWithMemberNumber
                            (inputId("Enter number of people in family: ")));
                    break;
                case 6:
                    try {
                        fc.createNewFamily(dataAboutFather(), dataAboutMother());
                    } catch (Exception ex) {
                        message("Incorrect input");
                    }
                    break;
                case 7:
                    fc.deleteFamilyByIndex(inputId("Enter family Id to delete"));
                    break;
                case 8:
                    int c = inputId("Enter next command.\n'1' - born child\n'2' - adopt child\n'3' - back to menu\n");
                    switch (c) {
                        case 1:
                            try {
                                fc.bornChild(inputId("Enter family id"),
                                        inputString("Enter name for boy "),
                                        inputString("Enter name for girl "));
                            } catch (NullPointerException ex) {
                                message("Wrong family index");
                            }
                            break;
                        case 2:
                            try {
                                fc.adoptChild(inputId("Enter family id "), dataAboutChild());
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
                    fc.deleteAllChildrenOlderThen(ageFilter);
                    break;
                case 10:
                    saveLoader.saveToFile(fc);
                    break;
                case 11:
                    try {
                        fc.loadData(saveLoader.loadFromFile());
//                        logger.info("Load data");
                    } catch (NullPointerException ex) {
                        message("No data in file");
                    }
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
        sb.append("10 - Save data\n");
        sb.append("11 - Load data\n");
        sb.append("0 - Exit\n");
        return sb.toString();
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

    private static int inputId(String s) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        message(s);
        try {
            return in.nextInt();
        } catch (InputMismatchException ex) {
//            logger.error(ex, "Wrong Id input");
            return -1;
        }
    }

    private static String inputString(String s) {
        Scanner in = new Scanner(System.in);
        message(s);
        return in.nextLine();
    }

    private static void message(String s) {
        System.out.println(s);
    }
}
