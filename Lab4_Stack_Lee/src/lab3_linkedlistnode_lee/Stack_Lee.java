package lab3_linkedlistnode_lee;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 08 SEP 2022 0941
 * Class that can add and remove from a doubly linked stack
 */

import java.util.Objects;

public class Stack_Lee {
    StackNode.slistNode head;
    StackNode.slistNode top;
    
    //Push new node
    public static Stack_Lee push (Stack_Lee list,
            float operand)
    {
        if (!Objects.isNull(list)) {
            StackNode.slistNode new_node = new StackNode.slistNode(operand);
            new_node.next = null;
            new_node.prev = null;
            
            if (list.head == null) {
                list.head = new_node;
                list.top = new_node;
                list.head.next = null;
                list.head.prev = null;
                list.top.next = null;
                list.top.next = null;
                
            } else {                
                new_node.next = null;       
                new_node.prev = list.top;
                list.head.next = new_node;                
                list.top = new_node;                                                   
            }
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
        return list;
    }
    
    //Pop nodes
    public static float pop (Stack_Lee list) 
    {                   
        float poppedNumber = 0;
        if (!Objects.isNull(list)) {        
            if (list.head == null) {
                System.out.println("Error: The stack is empty.");                               
            } else if (list.head.next == null){  //Only one node
                StackNode.slistNode tempNode = list.head;
                list.head = null;
                poppedNumber = tempNode.data;                
            } else {
                StackNode.slistNode tempNode = list.top;
                list.top = list.top.prev;
                list.top.next = null;
                poppedNumber = tempNode.data;
            }
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }    
        return poppedNumber;
    }    
}
