/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 23 Aug 2022 0941
 * User interface for interactive menu to interact with linked list
 */
import java.util.*;

public class UserInterface_Lee {
    
    //Reads user input
    public static void Interface(SinglyLinkedListClass_Lee list) {
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
                        //System.out.println(" 1 Display Content\n");
                        PrintObject(list);
                        break;
                    case 2:
                        //System.out.println(" 2 Add to the Contents\n");
                        int choice = 0;
                        System.out.println("Please enter a 1 or 2:");
                        System.out.println("Insert head - 1");
                        System.out.println("Insert tail - 2");
                        CheckIntegerInput(input);
                        choice = input.nextInt();
                        if(choice == 1 || choice == 2) {
                            SinglyLinkedListClass_Lee.insert(list, 5, choice);
                            SinglyLinkedListClass_Lee.insert(list, 6, choice);
                            SinglyLinkedListClass_Lee.insert(list, 7, choice);
                        } else {
                            System.out.println("Error: Incorrect choice.");
                        }
                        break;
                    case 3:
                        //System.out.println(" 3 Remove from the Contents\n");
                        System.out.println("Please enter a 1 or 2:");
                        System.out.println("Remove head - 1");
                        System.out.println("Remove tail - 2");
                        CheckIntegerInput(input);
                        choice = input.nextInt();
                        if(choice == 1 || choice == 2) {
                            SinglyLinkedListClass_Lee.remove(list, choice);
                            SinglyLinkedListClass_Lee.remove(list, choice);
                            SinglyLinkedListClass_Lee.remove(list, choice);
                        } else {
                            System.out.println("Error: Incorrect choice.");
                        }
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
    public static void PrintObject(SinglyLinkedListClass_Lee list) {
        if (!Objects.isNull(list) && !Objects.isNull(list.head)) {
            //System.out.println("Contents: ");
            SingleNode_Lee.slistNode currNode = list.head;
            System.out.print("Benedict Lee's Linked List: ");
            while (currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
        } else if (!Objects.isNull(list) && Objects.isNull(list.head)) {
            System.out.println("Error: The list is currently empty please "
                    + "supply input.");
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
        System.out.println("");
    }
}
