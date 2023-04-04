package lab7sorting_lee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 28 OCT 2022 2300 
 * User interface Class
 */
public class Interface_Lee {

    static ArrayList<String> importedList = new ArrayList<>();

    //Interface that prints out lists before and after sorting
    static void userInterface() {
        try ( Scanner input = new Scanner(System.in)) {
            System.out.println("This program allows you to import a "
                    + "CSV file to sort using 3 sorting algorithms.");
            
            //Add Filename Here
            String fileName = "Input_Lee\\20_descending.csv";

            //Import from CSV file
            inFile(fileName);

            //Converting to Array
            int[] importSort = new int[importedList.size()];
            if (!importedList.get(0).matches("[a-zA-Z]+")) { //Check if char                
                for (int i = 0; i < importedList.size(); i++) {
                    importSort[i] = Integer.parseInt(importedList.get(i));
                }
            } else { //If file contains integers
                StringBuilder str = new StringBuilder();
                for (String stringValue : importedList) {
                    str.append(String.valueOf(stringValue.toLowerCase()));
                }
                for (int i = 0; i < str.length(); i++) {
                    importSort[i] = (int) (str.charAt(i));
                }
            }

            //Unsorted list print to console
            System.out.println("Unsorted List:");
            for (String values : importedList) {
                System.out.print(values + " ");
            }

            //Bubble sort
            int[] bubbleSorted = Sorting_Lee.bubbleSort(importSort);
            //Insertion sort
            int[] insertionSorted = Sorting_Lee.insertionSort(importSort);
            //Selection sort
            int[] selectionSorted = Sorting_Lee.selectionSort(importSort);

            //Print sorted lists
            if (importedList.get(0).matches("[a-zA-Z]+")) { //Prints char
                System.out.println("\nBubble sorted List:");
                for (int i : bubbleSorted) {
                    System.out.print((char) i + " ");
                }
                System.out.println("\nInsertion sorted List:");
                for (int i : insertionSorted) {
                    System.out.print((char) i + " ");
                }
                System.out.println("\nSelection sorted List:");
                for (int i : selectionSorted) {
                    System.out.print((char) i + " ");
                }
            } else {
                System.out.println("\nBubble sorted List:");
                for (int i : bubbleSorted) {
                    System.out.print(i + " ");
                }
                System.out.println("\nInsertion sorted List:");
                for (int i : insertionSorted) {
                    System.out.print(i + " ");
                }
                System.out.println("\nSelection sorted List:");
                for (int i : selectionSorted) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("");

        } catch (Exception e) {
            System.out.println("An error has occured, please contact your "
                    + "administrator");
            System.exit(0);
        }
    }

    //Read CSV File into an Array
    static void inFile(String fileName) {
        try ( BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.toLowerCase().split(",");
                importedList.addAll(Arrays.asList(values));
            }
            if (importedList.isEmpty()) {
                System.out.println("The file is empty! Please try again!");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("There is a problem with reading the file. Please"
                    + " contact an Administrator.");
        }
    }
}
