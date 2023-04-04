/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 16 Aug 2022 1016
 * Driver class for assignment 1
 */

package partassig1_lee;

public class ArrayDriver_Lee {

    
    public static void main(String[] args) {
        double[] myList = new double[10];
        
        myList = UserInterface.UserInput(5, myList);
        
        Calculations.Summation(myList);
        
        Calculations.FindMax(myList);
        
        System.out.println("\nHave a nice day!");
        
    }
    
}
