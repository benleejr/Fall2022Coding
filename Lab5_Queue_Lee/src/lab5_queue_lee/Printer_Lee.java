package lab5_queue_lee;

import java.util.Objects;
import java.util.Scanner;
import java.io.File;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 13 SEP 2022
 * Class to interact with print queue
 */
public class Printer_Lee {

    static Object[][] titleAndPriority = {{"President", 1},
    {"Vice President", 2},
    {"Dean", 3},
    {"Department Head", 4},
    {"Coordinator", 5},
    {"Faculty", 6},
    {"Student", 7}};
    //Checks queue position by name
    public static void checkQueuePositionByTitle(Queue_Lee printQueue, Scanner input) {
        if (!Objects.isNull(printQueue) && !Objects.isNull(printQueue.front)) {
            int positionNumber = 1;
            QueueNode_Lee.qListNode currNode = printQueue.front;
            System.out.println("Which user would you like to check queue "
                    + "position for?");

            for (int row = 0; row < titleAndPriority.length; row++) {
                for (int col = 0; col < titleAndPriority[0].length; col++) {
                    System.out.print(titleAndPriority[row][col] + " ");
                }
                System.out.println("\n");
            }

            String title = "";
            UserInterface_Lee.CheckIntegerInput(input);
            int option = input.nextInt();

            switch (option) {
                case 1:
                    title = titleAndPriority[0][0].toString();
                    break;
                case 2:
                    title = titleAndPriority[1][0].toString();
                    break;
                case 3:
                    title = titleAndPriority[2][0].toString();
                    break;
                case 4:
                    title = titleAndPriority[3][0].toString();
                    break;
                case 5:
                    title = titleAndPriority[4][0].toString();
                    break;
                case 6:
                    title = titleAndPriority[5][0].toString();
                    break;
                case 7:
                    title = titleAndPriority[6][0].toString();
                    break;
                default:
                    System.out.println("You did not enter a valid corresponding "
                            + "number, please try again.");
                    break;
            }

            while (!currNode.name.equals(title)) {
                currNode = currNode.next;
                positionNumber++;
            }
            System.out.println("You are in position number " + positionNumber
                    + " of " + Queue_Lee.size(printQueue));
        } else if (!Objects.isNull(printQueue) && Objects.isNull(printQueue.front)) {
            System.out.println("Error: The list is currently empty.");
        } else {
            System.out.println("Error: There is a problem with the print queue.");
            System.exit(0);
        }
    }
    // Displays current print queue
    public static void displayPrintQueue(Queue_Lee printQueue) {
        if (!Objects.isNull(printQueue) && !Objects.isNull(printQueue.front)) {
            QueueNode_Lee.qListNode currNode = printQueue.front;
            System.out.println("Current Print Queue:");
            while (currNode != null) {
                System.out.print("Title: " + currNode.name + "\n");
                System.out.print("Priority: " + currNode.priority + "\n");
                System.out.print("Path: " + currNode.path + "\n\n");
                currNode = currNode.next;
            }
        } else if (!Objects.isNull(printQueue) && Objects.isNull(printQueue.front)) {
            System.out.println("Error: The list is currently empty please "
                    + "supply an input.");
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
        System.out.println("");
    }

    //Adds a print job 
    public static void addPrintJob(Queue_Lee printQueue, Scanner input) {

        try {
            int option = 0;
            System.out.println("Please input the integer corresponding to your title "
                    + "from the list below. ");
            for (int row = 0; row < titleAndPriority.length; row++) {
                for (int col = 0; col < titleAndPriority[0].length; col++) {
                    System.out.print(titleAndPriority[row][col] + " ");
                }
                System.out.println("");
            }
            UserInterface_Lee.CheckIntegerInput(input);
            option = input.nextInt();
            input.nextLine();
            System.out.print("Please input your filepath: ");
            String filePath = input.nextLine();

            switch (option) {
                case 1:
                    Queue_Lee.enqueue(printQueue,
                            titleAndPriority[0][0].toString(), filePath,
                            (int) titleAndPriority[0][1]);
                    break;
                case 2:
                    Queue_Lee.enqueue(printQueue,
                            titleAndPriority[1][0].toString(), filePath,
                            (int) titleAndPriority[1][1]);
                    break;
                case 3:
                    Queue_Lee.enqueue(printQueue,
                            titleAndPriority[2][0].toString(), filePath,
                            (int) titleAndPriority[2][1]);
                    break;
                case 4:
                    Queue_Lee.enqueue(printQueue,
                            titleAndPriority[3][0].toString(), filePath,
                            (int) titleAndPriority[3][1]);
                    break;
                case 5:
                    Queue_Lee.enqueue(printQueue,
                            titleAndPriority[4][0].toString(), filePath,
                            (int) titleAndPriority[4][1]);
                    break;
                case 6:
                    Queue_Lee.enqueue(printQueue,
                            titleAndPriority[5][0].toString(), filePath,
                            (int) titleAndPriority[5][1]);
                    break;
                case 7:
                    Queue_Lee.enqueue(printQueue,
                            titleAndPriority[6][0].toString(), filePath,
                            (int) titleAndPriority[6][1]);
                    break;
            }
        } catch (Exception e) {
            System.out.println("An unknown error occured, contact your administrator "
                    + "at 850 - 555 - 4000.");
            System.exit(0);
        }
    }

    //Checks queue position by file name
    public static void checkDocumentPosition(Queue_Lee printQueue, Scanner input) {
        if (!Objects.isNull(printQueue) && !Objects.isNull(printQueue.front)) {
            QueueNode_Lee.qListNode currNode = printQueue.front;
            System.out.print("Please enter the file name (including its "
                    + "extension): ");
            input.nextLine();
            String fileName = input.nextLine();
            int queuePosition = 1;
            File f = new File(currNode.path);
            while (currNode != null) {
                f = new File(currNode.path);
                if (fileName.equals(f.getName())) {
                    System.out.println("The document " + fileName
                            + " is in position " + queuePosition + " of "
                            + Queue_Lee.size(printQueue));
                    break;
                }
                currNode = currNode.next;
                queuePosition++;
            }
            if (!fileName.equals(f.getName())) {
                System.out.println("Error: the file name you specified does not match "
                        + "any of the file names in the queue.");
            }

        } else if (!Objects.isNull(printQueue) && Objects.isNull(printQueue.front)) {
            System.out.println("Error: The list is currently empty.");
        } else {
            System.out.println("Error: There is a problem with the print queue.");
            System.exit(0);
        }
    }
    //prints list to console and ends program
    public static void finishPrinting(Queue_Lee printQueue) {
        if (!Objects.isNull(printQueue) && !Objects.isNull(printQueue.front)) {
            QueueNode_Lee.qListNode currNode = printQueue.front;
            while (currNode != null) {
                System.out.print("Name: " + currNode.name
                        + "\nPriority: " + currNode.priority
                        + "\nPath: " + currNode.path);
                currNode = currNode.next;
                System.out.println("\n");
            }
            System.out.println("End of program.");
            System.exit(0);
        } else if (!Objects.isNull(printQueue) && Objects.isNull(printQueue.front)) {
            System.out.println("Error: The print queue is currently empty.");
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
        System.out.println("");
    }
}
