
/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 23 Aug 2022 0941
 * Class that can add and remove from a singly linked list
 */

import java.util.Objects;

public class SinglyLinkedListClass_Lee {
    SingleNode_Lee.slistNode head;
    
    //Inserts new node
    public static SinglyLinkedListClass_Lee insert (SinglyLinkedListClass_Lee list,
            int data, int choice) 
    {
        if (!Objects.isNull(list)) {
            SingleNode_Lee.slistNode new_node = new SingleNode_Lee.slistNode(data);
            new_node.next = null;
            
            if (list.head == null) {
                list.head = new_node;
            } else {
                switch (choice) {
                    case 1:
                        new_node.next = list.head;
                        list.head = new_node;
                        break;
                    case 2:                        
                        SingleNode_Lee.slistNode curr = list.head;
                        while (curr.next != null) {
                            curr = curr.next;                            
                        } 
                        curr.next = new_node;
                        break;
                    default:
                        System.out.println("Error: Incorrect choice.");
                        break;
                }
            }
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
        return list;
    }
    
    //remove node
    public static SinglyLinkedListClass_Lee remove (SinglyLinkedListClass_Lee list, 
            int choice) 
    {
        if (!Objects.isNull(list)) {        
            if (list.head == null) {
                System.out.println("Error: Cannot remove, list is empty.");
            } else {
                SingleNode_Lee.slistNode removeNode = list.head;
                SingleNode_Lee.slistNode node = list.head;
                switch (choice) {
                    case 1:
                        if (list.head != null && removeNode.next != null) {
                            list.head = node;
                        }
                        removeNode = null;
                        break;                        
                    case 2:
                        while (removeNode.next != null) {
                            node = removeNode;
                            removeNode = removeNode.next;
                        }
                        removeNode = null;
                        node.next = null;
                        break;
                    default:
                        System.out.println("Error: Incorrect choice.");
                        break;
                }
            }
        } else {
            System.out.println("Error: There is a problme with the list.");
            System.exit(0);
        }
        return list;
    }
}
