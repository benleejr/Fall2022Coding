package lab6_minmaxheap_lee;

import java.util.Objects;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 10 OCT 2022 0850
 *  Class for manipulating Binary Tree
 */
public class HeapManagement_Lee {

    HeapNode_Lee.heapNode root;
    HeapNode_Lee.heapNode last;
    HeapNode_Lee.heapNode parent, left, right;
    static Boolean isMinHeap;
    static int rank;

    //Method for inserting into binary tree when user chooses to add to contents
    public static void insert(HeapManagement_Lee heap, HeapNode_Lee.heapNode currNode,
            int data) {
        if (!Objects.isNull(heap)) {
            HeapNode_Lee.heapNode newNode = new HeapNode_Lee.heapNode(data);
            if (heap.root == null) { //Empty heap
                heap.root = newNode;
                heap.last = newNode;
                System.out.println("Successfully inserted " + data + " into heap");
            } else if (heap.root.left != null) { //Root left child not empty
                currNode.right = newNode;
                currNode.right.parent = currNode;
                heap.last = currNode.right;
                heapify(heap, heap.last);
                System.out.println("Successfully inserted " + data + " into heap");
            } else if (heap.root.right == null) { //Root right child is empty
                currNode.left = newNode;
                currNode.left.parent = currNode;
                heap.last = currNode.left;
                heapify(heap, heap.last);
                System.out.println("Successfully inserted " + data + " into heap");
            } else if (currNode.parent.right == null) { //Right node is empty
                currNode.parent.right = newNode;
                currNode.parent.right.parent = currNode.parent;
                heap.last = currNode.parent.right;
                heapify(heap, heap.last);
                System.out.println("Successfully inserted " + data + " into heap");
            } else if (currNode.parent.right != null) { //Right of last node parent is not null
                currNode = nextEmpty(heap, currNode);
                currNode.left = newNode;
                currNode.left.parent = currNode;
                heap.last = currNode.left;
                heapify(heap, heap.last);
                System.out.println("Successfully inserted " + data + " into heap");
            } else { //Left of last node parent is empty
                newNode.parent = heap.last;
                heap.last.left = newNode;
                heap.last = heap.last.left;
                heapify(heap, heap.last);
                System.out.println("Successfully inserted " + data + " into heap");
            }
        } else {
            System.out.println("Error: There is a problem with inserting into "
                    + "the list.");
            System.exit(0);
        }
    }

//Finds the next empty node
    static HeapNode_Lee.heapNode nextEmpty(HeapManagement_Lee heap,
            HeapNode_Lee.heapNode currNode) {
        if (currNode.parent.right == currNode) {
            nextEmpty(heap, currNode.parent);
        }
        currNode = currNode.parent.right;
        if (currNode.left != null) {
            nextEmpty(heap, currNode.left);
        }
        return currNode;
    }

    //Recurses through tree and assigns an inOrderRank
    static void inOrder(HeapManagement_Lee heap, HeapNode_Lee.heapNode currNode) {
        if (!Objects.isNull(heap)) {
            if (currNode.left != null) {
                inOrder(heap, currNode.left);
            }
            currNode.setInOrderRank(rank++);
            if (currNode.right != null) {
                inOrder(heap, currNode.right);
            }
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
    }

    //Prints binary tree in order
    static void inOrderPrint(HeapManagement_Lee heap, HeapNode_Lee.heapNode currNode) {
        if (!Objects.isNull(heap)) {
            if (currNode.left != null) {
                inOrderPrint(heap, currNode.left);
            }
            System.out.print(currNode.data + " ");
            if (currNode.right != null) {
                inOrderPrint(heap, currNode.right);
            }
        } else {
            System.out.print("Error: There is a problem with the list.");
            System.exit(0);
        }
    }

    //removes integer specified by user
    public static void removeMin(HeapManagement_Lee heap,
            HeapNode_Lee.heapNode currNode) {
        try {
            HeapNode_Lee.heapNode tempNode;
            if (heap.root == null) {
                System.out.println("The tree is empty!");
            } else if (heap.root.left == null && heap.root.right == null) {
                heap.root = null;
            } else if (isMinHeap == true) {
                tempNode = heap.last;
                heap.last.data = heap.root.data;
                heap.root.data = tempNode.data;
                currNode = findLastNode(heap, heap.last);
                heap.last = null;
                heap.last = currNode;
                heapify(heap, currNode);
            } else {
                currNode = findLastNode(heap, heap.last);
                heap.last = null;
                heap.last = currNode;
                heapify(heap, currNode);
            }
        } catch (Exception e) {
            System.out.println("The integer you are looking for does not exist.");
        }
    }

    //Removes all nodes from tree
    static void clearTree(HeapManagement_Lee heap, HeapNode_Lee.heapNode currNode) {
        while (heap.root != null) {
            removeMin(heap, heap.root);
        }
        System.out.println("Tree cleared!");
    }

    //Finds second-to-last node
    static HeapNode_Lee.heapNode findLastNode(HeapManagement_Lee heap,
            HeapNode_Lee.heapNode currNode) {
        if (currNode.parent.left == currNode) {
            findLastNode(heap, currNode.parent);
        }
        currNode = currNode.parent.left;
        if (currNode.right != null) {
            findLastNode(heap, currNode.parent);
        }
        return currNode;
    }

    //Swap node keys
    static void swap(HeapManagement_Lee heap, HeapNode_Lee.heapNode swapNode1,
            HeapNode_Lee.heapNode swapNode2) {
        HeapNode_Lee.heapNode tempNode = new HeapNode_Lee.heapNode(swapNode2.data);               
        if (heap.last.data == swapNode1.data) {
            heap.last = swapNode2;
        }
        swapNode2.data = swapNode1.data;        
        swapNode1.data = tempNode.data;
        
    }

    //Heapify tree 
    private static void heapify(HeapManagement_Lee heap,
            HeapNode_Lee.heapNode currNode) {
        HeapNode_Lee.heapNode tempNode;
        if (currNode.parent!= null && isMinHeap == true && 
                currNode.data < currNode.parent.data || 
                currNode.parent != null && isMinHeap == 
                false && currNode.data > currNode.parent.data) {
            swap(heap, currNode, currNode.parent);
            /*tempNode = currNode.parent;
            currNode.parent.data = currNode.data;
            currNode.data = tempNode.data;*/
            heapify(heap, currNode.parent);
        }
    }

    //Recurses left until the next largest node is found
    private static int nextLargest(HeapManagement_Lee heap,
            HeapNode_Lee.heapNode currNode) {
        int number = currNode.data;
        while (currNode.left != null) {
            number = currNode.left.data;
            currNode = currNode.left;
        }
        return number;
    }

    //Reset inorder rank counter 
    public static void setRankZero() {
        rank = -1;
    }

    //
    public static void setMinMax(Boolean minMaxTF) {
        isMinHeap = minMaxTF;
    }

    public static Boolean getMinMax() {
        return isMinHeap;
    }
}
