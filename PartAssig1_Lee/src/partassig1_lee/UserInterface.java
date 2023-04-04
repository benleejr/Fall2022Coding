/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 16 Aug 2022 1016
 * Class containing methods for user interface through the console
 */

package partassig1_lee;

import java.util.*;

public class UserInterface {
    
    //User interface method that instructs users to enter 5 numbers
    public static double[] UserInput(int N, double[] myList)
    {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Please enter 5 numbers with a space between.");
            
            for(int i = 0; i < N; i++)
                myList[i] = input.nextDouble();
        }
        catch(Exception e) {
            System.out.println("Error: Incorrect input supplied.");
            System.exit(0);
        }
        myList = Calculations.RandomNumbers(5, myList);
        
        return myList;
    }
    
    //Method that prints out the elements in the Array
    public static void Print(double[] myList)
    {
        if(myList != null && myList.length > 0) {
            System.out.println("\nArray Elements:");
            
            for (int i = 0; i < myList.length; i++) {
                System.out.println("[" + myList[i] + "]");
            }
            System.out.println("\n");
        }
        else {
            System.out.println("Error: List is empty.");
            System.exit(0);
        }
    }
}
