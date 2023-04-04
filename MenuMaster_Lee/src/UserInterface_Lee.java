/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 19 Aug 2022 1703
 * User interface for interactive menu 
 */
import java.util.*;

public class UserInterface_Lee {
    
    //Reads user input
    public static void Interface() {
        System.out.println("---Welcome to the main menu.---");
        try (Scanner input = new Scanner(System.in)) {
            int option = 0;
            while (option != 6)
            {
                PrintMenuMessage();
                CheckIntegerInput(input);
                option = input.nextInt();
                switch(option) {
                    case 1:
                        System.out.println(" 1 Display Content\n");
                        PrintObject();
                        break;
                    case 2:
                        System.out.println(" 2 Add to the Contents\n");
                        break;
                    case 3:
                        System.out.println(" 3 Remove from the Contents\n");
                        break;
                    case 4:
                        System.out.println(" 4 Rearrange Contents\n");
                        break;
                    case 5:
                        System.out.println(" 5 Clear the contents\n");
                        break;
                    case 6:
                        System.out.println(" 6 Exit Program\n");
                        System.out.println("Thanks for using our program.");
                        System.exit(0);
                    default:
                        System.out.println("Error: " + option + " is not a correct choice,"
                            + "please enter a new option.\n");
                        break;
                }
            }
        }
        catch(Exception e) {
            System.out.println("An unknown error occured, contact your administrator"
                + "at 850 - 555 - 4000.");
            System.exit(0);
        }
    }
    
    // Checks for valid input
    public static void CheckIntegerInput(Scanner input) {
        while(!input.hasNextInt()) {
            String inp = input.next();
            System.out.println("Error: " + inp + " is not a valid integer.\n");
            PrintMenuMessage();
        }
    }
    
    //Prints UI menu to console
    public static void PrintMenuMessage() {
        System.out.println("Please enter an option given below.");
        System.out.println("Option Operation Completed");
        System.out.println("------------------------------");
        System.out.println(" 1 Display Contents");
        System.out.println(" 2 Add to the Contents");
        System.out.println(" 3 Remove from the Contents");
        System.out.println(" 4 Rearrange Contents");
        System.out.println(" 5 Clear the contents");
        System.out.println(" 6 Exit Program");
    }
    
    //Prints contents
    public static void PrintObject() {
        System.out.println("Contents: ");
    }
}
