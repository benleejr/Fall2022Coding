package lab3_linkedlistnode_lee;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 30 Aug 2022 0948
 * Driver class for linked list program
 */

import java.util.Objects;

public class Lab3_LinkedListNode_Lee {
    public static void main(String[] args) {
        DoublyLinkedListClass_Lee list = new DoublyLinkedListClass_Lee();
        if (!Objects.isNull(list)) {
        UserInterface_Lee.Interface(list);
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
    }
    
}
