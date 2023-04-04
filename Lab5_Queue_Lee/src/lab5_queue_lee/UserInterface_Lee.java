package lab5_queue_lee;
/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 13 SEP 2022 0934
 * User interface for interactive menu to interact with linked list
 */
import java.util.*;

public class UserInterface_Lee {

    //Reads user input
    public static void Interface(Queue_Lee printQueue) {

        System.out.println("---Welcome to the main menu.---");

        try (Scanner input = new Scanner(System.in);) {
            int option = 0;

            while (option >= 0) {
                
                PrintMenuMessage();
                CheckIntegerInput(input);
                option = input.nextInt();                
                switch (option) {
                    case 1:
                        Printer_Lee.displayPrintQueue(printQueue);
                        break;
                    case 2:
                        Printer_Lee.addPrintJob(printQueue, input);
                        break;
                    case 3:
                        Printer_Lee.checkQueuePositionByTitle(printQueue, input);
                        break;
                    case 4:
                        Printer_Lee.checkDocumentPosition(printQueue, input);
                        break;
                    case -1:
                        Printer_Lee.finishPrinting(printQueue);
                        break;
                    default:
                        System.out.println("Error: " + option + " is not a correct choice, "
                                + "please enter a number corresponding to a menu "
                                + "option.\n");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("An unknown error occured, contact your administrator "
                    + "at 850 - 555 - 4000.");
            System.exit(0);
        }
    }

    // Checks for valid input
    public static void CheckIntegerInput(Scanner input) {
        while (!input.hasNextInt()) {
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
        System.out.println(" 1 Display Print Queue");
        System.out.println(" 2 Add a New Print Job");
        System.out.println(" 3 Check position in queue by title");
        System.out.println(" 4 Check position in queue by file name");
        System.out.println(" -1 Complete All Print Jobs and Exit Program");
    }
}
