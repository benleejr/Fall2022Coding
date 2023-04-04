package lab3_linkedlistnode_lee;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 06 SEP 2022 0923
 * User interface to input a calculation in Reverse Polish Notation
 */
import java.util.*;

public class UserInterface_Lee {    
    //Reads user input
    public static void Interface(Stack_Lee list) {        
        try (Scanner input = new Scanner(System.in)) {
            String operator = "";
            float operand = 0;
            int stackSize = 0; //tracks push() and pop()
            PrintMenuMessage();            
            while (input.hasNext()) {        
                if (input.hasNextFloat() && stackSize < 2 && !(stackSize < 0)) {         
                    operand = input.nextFloat();
                    if (operand == -1) {
                        break;
                    } 
                    Stack_Lee.push(list, operand);
                    stackSize++;
                } else if (input.hasNext() && stackSize == 2) {
                    operator = input.next();
                    switch(operator) {
                        case "+":                                    
                            Calculator_Lee.add(list);
                            stackSize--;
                            break;
                        case "-":            
                            Calculator_Lee.subtract(list); 
                            stackSize--;
                            break;
                        case "/":            
                            Calculator_Lee.divide(list);        
                            stackSize--;
                            break;
                        case "*":            
                            Calculator_Lee.multiply(list); 
                            stackSize--;
                            break;
                        default:
                            System.out.println("You did not enter a valid operator,"
                            + " please try again.");
                            PrintMenuMessage(); 
                            stackSize = 0;
                            input.nextLine();
                    }
                } else {
                    System.out.println("""
                                       \nYour input is invalid, please follow the 
                                       instructions stated at the beginning.\n""");
                    PrintMenuMessage();
                    input.nextLine();
                }
            }
            System.out.println("The result is: " + list.top.data + " \n\nThank you"
                    + "for using this program.");            
        }        
        catch(Exception e) {
            System.out.println("An unknown error occured, contact your administrator "
                + "at 850 - 555 - 4000.");
            System.exit(0);
        }
    }
    
    //Prints UI menu to console
    public static void PrintMenuMessage() {
        System.out.println("""
                           Please input a calculation in Reverse Polish Notation
                           and input the integer "-1" at the end of the calculation:""");        
    }    
}

