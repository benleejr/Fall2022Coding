package lab5_queue_lee;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 13 SEP 2022 0930
 * Class that can add and remove from a doubly linked list queue
 */
import java.util.Objects;

public class Queue_Lee {

    QueueNode_Lee.qListNode front;
    QueueNode_Lee.qListNode back;

    //Inserts new node
    public static Queue_Lee enqueue(Queue_Lee list, String name, String filePath,
            int priority) {
        if (!Objects.isNull(list)) {
            QueueNode_Lee.qListNode new_node = new QueueNode_Lee.qListNode(name,
                    filePath, priority);
            new_node.next = null;
            if (list.front == null) { //Add to empty queue
                list.front = new_node;
                list.back = list.front;
                list.front.prev = null;
                list.back.next = null;
            } else if (list.front.priority > new_node.priority) {
                QueueNode_Lee.qListNode curr = list.front;
                new_node.next = curr;
                curr.prev = new_node;
                list.front = new_node;
                list.front.prev = null;
                list.back.next = null;
            } else if (list.back.priority < new_node.priority) {
                QueueNode_Lee.qListNode prev = list.back;
                new_node.prev = prev;
                prev.next = new_node;
                list.back = new_node;
                list.front.prev = null;
                list.back.next = null;
            } else if (list.back.priority == new_node.priority) {
                new_node.next = null;
                list.back.next = new_node;
                new_node.prev = list.back;
                list.back = new_node;
            } else {
                QueueNode_Lee.qListNode curr = list.front;
                QueueNode_Lee.qListNode prev = list.front;

                while (curr.priority < new_node.priority) {
                    prev = curr;
                    curr = curr.next;
                }
                while (curr.priority == new_node.priority) {
                    prev = curr;
                    curr = curr.next;
                }
                new_node.next = curr;
                new_node.prev = prev;
                curr.prev = new_node;
                prev.next = new_node;
                list.front.prev = null;
                list.back.next = null;
            }
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
        return list;
    }

    //Remove nodes
    public static Queue_Lee dequeue(Queue_Lee list) {
        if (!Objects.isNull(list)) {
            if (list.front.next == null && list.back.prev == null) {
                list.front = null;
                list.back = null;
            } else if (list.front == null && list.back == null) {
                System.out.println("Error: Cannot remove, list is empty.");
            } else {
                QueueNode_Lee.qListNode removeNode = list.front;
                QueueNode_Lee.qListNode nextNode = list.front.next;
                if (list.front != null && removeNode.next != null) {
                    list.front.next = nextNode.next;
                    list.front = nextNode;
                    list.front.prev = null;
                }
            }
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
        return list;
    }
    //Gets size of queue
    public static int size(Queue_Lee list) {
        QueueNode_Lee.qListNode iterator = list.front;
        int i = 1;
        while (iterator.next != null) {
            iterator = iterator.next;
            i++;
        }
        return i;
    }
}
