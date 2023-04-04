package lab3_linkedlistnode_lee;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 06 SEP 2022 0948
 * Driver class for linked list program
 */

import java.util.Objects;

public class Lab4_Stack_Lee {
    public static void main(String[] args) {
        Stack_Lee stack = new Stack_Lee();
        if (!Objects.isNull(stack)) {
            UserInterface_Lee.Interface(stack);
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
    }
    
}
