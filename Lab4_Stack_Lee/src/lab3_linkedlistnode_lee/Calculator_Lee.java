package lab3_linkedlistnode_lee;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 06 SEP 2022 0923
 * Manipulates stack to obtain stored operands and store the result
 */

public class Calculator_Lee {
    public static void add (Stack_Lee list) {      
        float operand1 = Stack_Lee.pop(list);
        float operand2 = Stack_Lee.pop(list);
        Stack_Lee.push(list, operand2 + operand1);        
    }
    
    public static void subtract (Stack_Lee list) { 
        float operand1 = Stack_Lee.pop(list);
        float operand2 = Stack_Lee.pop(list);
        Stack_Lee.push(list, operand2 - operand1);  
    }
    
    public static void multiply (Stack_Lee list) {    
        float operand1 = Stack_Lee.pop(list);
        float operand2 = Stack_Lee.pop(list);
        Stack_Lee.push(list, operand2 * operand1);         
    }
    
    public static void divide (Stack_Lee list) {
        float operand1 = Stack_Lee.pop(list);
        float operand2 = Stack_Lee.pop(list);
        Stack_Lee.push(list, operand2 / operand1);        
    }
}
