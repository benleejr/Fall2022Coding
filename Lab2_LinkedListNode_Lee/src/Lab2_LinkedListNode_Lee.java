/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 23 Aug 2022 0941
 * Driver class for linked list program
 */

import java.util.Objects;

public class Lab2_LinkedListNode_Lee {
    public static void main(String[] args) {
        SinglyLinkedListClass_Lee list = new SinglyLinkedListClass_Lee();
        if (!Objects.isNull(list)) {
        UserInterface_Lee.Interface(list);
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
    }
}
