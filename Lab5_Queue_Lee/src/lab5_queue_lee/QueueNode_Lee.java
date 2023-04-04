package lab5_queue_lee;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 13 SEP 2022 0936
 *  Class with template node
 */

public class QueueNode_Lee {
    static class qListNode {
        String path;
        String name;
        int priority;
        qListNode next;
        qListNode prev;
        
        qListNode (String name, String path, int priority) {
            this.name = name;
            this.path = path;
            this.priority = priority;
            next = null;
            prev = null;
        }
    }
}
