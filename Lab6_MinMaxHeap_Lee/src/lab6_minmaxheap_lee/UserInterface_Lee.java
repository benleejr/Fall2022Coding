package lab6_minmaxheap_lee;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Random;
import java.util.Set;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 10 OCT 2022 0850
 *  User interface class to interact with Heap
 */
public class UserInterface_Lee {
    HeapNode_Lee.heapNode root;
    static int randomGeneratorCounter = 0;

    //Reads user input
    public static void Interface(HeapManagement_Lee heap) {
        System.out.println("---Welcome to the main menu.---");
        try (Scanner input = new Scanner(System.in)) {
            int option = 0;
            boolean treeCleared = true;
            Boolean isTrue = true;
            Boolean isFalse = false;
            while (option != 6) {                
                if (treeCleared == true) {
                    System.out.println("1 Min Heap\n2 Max Heap\n6 Exit Program");
                    checkIntegerInput(input);
                    option = input.nextInt();
                    switch (option) {
                        case 1: //Min Heap
                            HeapManagement_Lee.setMinMax(isTrue);
                            break;
                        case 2: //Max Heap
                            HeapManagement_Lee.setMinMax(isFalse);
                            break;
                        case 6: //Exit program
                            System.out.println("Goodbye.");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Error: " + option + " is not a valid "
                                    + "choice please enter a new option.\n");
                            break;
                    }
                }

                printMenuMessage();
                checkIntegerInput(input);
                option = input.nextInt();
                switch (option) {
                    case 1:
                        System.out.println(" 1 Display Heap\n");
                        int level = 1;
                        if (heap.root == null) {
                            System.out.println("The list is empty! please add "
                                    + "to the list!\n");                            
                        } else if (HeapManagement_Lee.getMinMax() == true) {
                            System.out.println("The Min Heap is");
                            while(printObject(heap, heap.root, level)) {
                                level++;
                            }
                        } else {
                            System.out.println("The Max Heap is");
                            while(printObject(heap, heap.root, level)) {
                                level++;
                            }
                        }
                        System.out.println("");
                        break;
                    case 2:
                        System.out.println(" 2 Add to the Contents\n");
                        System.out.print("Please input an integer you would"
                                + " like to store: ");
                        checkIntegerInput(input);
                        int data = input.nextInt();
                        HeapManagement_Lee.insert(heap, heap.last, data);   
                        treeCleared = false;
                        input.nextLine();
                        break;
                    case 3:
                        System.out.println(" 3 Remove from the Contents\n");                        
                        HeapManagement_Lee.removeMin(heap, heap.root);                        
                        break;
                    case 4:
                        System.out.println(" 5 Clear the heap\n");
                        System.out.println("-----Tree has been cleared-----");
                        treeCleared = true;
                        break;
                    case 6:
                        System.out.println(" 6 Exit Program\n");
                        System.out.println("Thanks for using our program.");
                        System.exit(0);
                    default:
                        System.out.println("Error: " + option + " is not a valid "
                                + "choice please enter a new option.\n");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("An unknown error occured, contact your administrator "
                    + "at 850 - 555 - 4000.");
            System.exit(0);
        }
    }

    private static void random(HeapManagement_Lee Heap) {
        Random randGen = new Random();
        int maximum = 1000;
        Set<Integer> generatedNumbers = new LinkedHashSet<>();
        while (generatedNumbers.size() != 50) {
            Integer nextNumber = randGen.nextInt(maximum) + 1;
            generatedNumbers.add(nextNumber);
        }
        ArrayList<Integer> numbers = new ArrayList<>(generatedNumbers);
        for (int i = 0; i < numbers.size(); i++) {
            HeapManagement_Lee.insert(Heap, Heap.root, numbers.get(i));
        }
    }

    // Checks for valid input
    public static void checkIntegerInput(Scanner input) {
        while (!input.hasNextInt()) {
            String inp = input.next();
            System.out.println("Error: " + inp + " is not a valid integer.\n");
            printMenuMessage();
        }
    }

    //Prints UI menu to console
    public static void printMenuMessage() {
        System.out.println("Please enter an option given below.");
        System.out.println("Option Operation Completed");
        System.out.println("------------------------------");
        System.out.println(" 1 Display Heap");
        System.out.println(" 2 Add to the Contents");
        System.out.println(" 3 Remove from the Contents");
        System.out.println(" 4 Clear the Heap"); 
        System.out.println(" 6 Exit Program");
    }

    //Prints contents
    public static Boolean printObject (HeapManagement_Lee heap,
            HeapNode_Lee.heapNode currNode, int level) {        
        currNode = heap.root;
        if(level == 1) {
            System.out.println("PARENT: " + currNode.data + " LEFT CHILD: "
            + currNode.left.data + " RIGHT CHILD: " + currNode.right.data);
            return true;
        }
        boolean left = printObject(heap, currNode.left, level - 1);
        boolean right = printObject(heap, currNode.right, level - 1);
        
        return left || right;
    }
    
    
}
