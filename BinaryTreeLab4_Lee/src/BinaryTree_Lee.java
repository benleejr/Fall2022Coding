
import java.util.Objects;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 30 SEP 2022 2000
 *  Class for manipulating Binary Tree
 */
public class BinaryTree_Lee {

    BinaryTreeNode_Lee.bTreeNode root;
    
    BinaryTreeNode_Lee.bTreeNode parent, left, right;
    static int rank;

    //Method for inserting into binary tree when user chooses to add to contents
    public static void insert(BinaryTree_Lee tree, BinaryTreeNode_Lee.bTreeNode currNode,
            int data) {
        if (!Objects.isNull(tree)) {
            rank = -1;
            BinaryTreeNode_Lee.bTreeNode newNode = new BinaryTreeNode_Lee.bTreeNode(data);
            if (tree.root == null) {
                tree.root = newNode;
                newNode.setInOrderRank(0);
            } else if (newNode.data < currNode.data) {
                if (currNode.left != null) {
                    insert(tree, currNode.left, data);
                } else {
                    currNode.left = newNode;
                    newNode.parent = currNode;
                }
            } else if (newNode.data > currNode.data) {
                if (currNode.right != null) {
                    insert(tree, currNode.right, data);
                } else {
                    currNode.right = newNode;
                    newNode.parent = currNode;
                }
            } else if (newNode.data == currNode.data) {
                System.out.println("An node with the value " + newNode.data
                        + " already exists. Please check your input");
            }
            inOrder(tree, tree.root);
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
    }

    //Recurses through tree and assigns inOrderRank
    public static void inOrder(BinaryTree_Lee tree, BinaryTreeNode_Lee.bTreeNode currNode) {
        if (!Objects.isNull(tree)) {
            if (currNode.left != null) {
                inOrder(tree, currNode.left);
            }
            rank++;
            currNode.setInOrderRank(rank);
            if (currNode.right != null) {
                inOrder(tree, currNode.right);
            }
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
    }

}
