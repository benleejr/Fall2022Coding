/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 16 Aug 2022 1016
 * Methods that calculate the sum and largest number of the 5 numbers inputted by user
 */

package partassig1_lee;

import java.util.Objects;

public class Calculations {
    
    //Method that is a random number creator
    public static double[] RandomNumbers(int N, double[] myList)
    {
        if(!Objects.isNull(myList) && myList.length > 0 
                && N >= 0 && N < myList.length) {
            for (int i = N; i < myList.length; i++) {
                myList[i] = (double) (Math.random() * 10);                
            }
        }
        else {
            System.out.println("error: There is a problem with the input.");
            System.exit(0);            
        }
        
        return myList;
    }
    
    //Method for finding the sum of the numbers inputted by the user
    public static void Summation(double[] myList)
    {
        double total = 0;
        
        if(!Objects.isNull(myList) && myList.length > 0) {
            for (int i = 0; i < myList.length; i++) {
                total += myList[i];
            }
            System.out.println("Total is " + total);
        }
        else {
            System.out.println("Error: There is a problem with the input.");
            System.exit(0);
        }
    }
    
    //Method for finding the largest number of the 5 numbers inputted
    public static void FindMax(double[] myList)
    {
        double max = 0;
        
        if(!Objects.isNull(myList)&& myList.length > 0) {
            max = myList[0];
            
            for (int i = 1; i <myList.length; i++) {
                if (myList[i] > max) max = myList[i];
            }
            System.out.println("Max is " + max);
        }
        else {
            System.out.println("Error: There is a problem with the input.");
            System.exit(0);
        }
    }
    
}
    

