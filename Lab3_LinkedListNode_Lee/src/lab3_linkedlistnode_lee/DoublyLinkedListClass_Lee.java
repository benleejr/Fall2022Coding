package lab3_linkedlistnode_lee;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 30 Aug 2022 0941
 * Class that can add and remove from a singly linked list
 */

import java.util.Objects;

public class DoublyLinkedListClass_Lee {
    DoubleNode_Lee.dListNode head;
    DoubleNode_Lee.dListNode tail;
    
    //Inserts new node
    public static DoublyLinkedListClass_Lee insert (DoublyLinkedListClass_Lee list,
            int data, int choice) 
    {
        if (!Objects.isNull(list)) {
            DoubleNode_Lee.dListNode new_node = new DoubleNode_Lee.dListNode(data);
            new_node.next = null;            
            
            if (list.head == null) {
                list.head= new_node;                               
                list.tail = list.head;                
                list.head.prev = null;
                list.tail.next = null;
            } else {
                switch (choice) {
                    case 1:
                        DoubleNode_Lee.dListNode current = list.head;                  
                        list.head = new_node;
                        list.head.next = current;
                        current.prev = list.head;                                              
                        break;
                    case 2:
                        DoubleNode_Lee.dListNode last = list.tail;                            
                        list.tail = new_node;
                        last.next = list.tail;
                        list.tail.prev = last;                        
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
    
    //Remove nodes
    public static DoublyLinkedListClass_Lee remove (DoublyLinkedListClass_Lee list, 
            int choice) 
    {
        if (!Objects.isNull(list)) {        
            if (list.head.next == null && list.tail.prev == null) {
                list.head = null;
                list.tail = null;
            } else if (list.head == null && list.tail == null) {
                System.out.println("Error: Cannot remove, list is empty.");                
            } else {   
                DoubleNode_Lee.dListNode removeNode = list.head;                
                switch (choice) {
                    case 1:
                        DoubleNode_Lee.dListNode nextNode = list.head.next;
                        if (list.head != null && removeNode.next != null) {
                            list.head.next = nextNode.next; 
                            list.head = nextNode;
                            list.head.prev = null;
                        }                                            
                        removeNode = null;
                        break;
                    case 2:                        
                        removeNode = list.tail;                        
                        DoubleNode_Lee.dListNode prevNode = removeNode.prev;                                               
                        list.tail.prev = prevNode.prev;
                        list.tail = prevNode;
                        list.tail.next = null;
                        removeNode = null;                        
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
}
