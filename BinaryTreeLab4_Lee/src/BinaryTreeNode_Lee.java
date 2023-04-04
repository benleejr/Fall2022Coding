/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 30 SEP 2022 2000
 *  Class with template node and setters and getters
 */

public class BinaryTreeNode_Lee {
    static class bTreeNode {
        int data;
        bTreeNode parent;
        bTreeNode left;        
        bTreeNode right;
        Boolean leftVisited;
        Boolean rightVisited;
        Boolean isLeaf;
        int inOrderRank;
        
        
        bTreeNode (int d) {
            data = d;
            parent = null;
            left = null;
            right = null;
            leftVisited = false;
            rightVisited = false;
            isLeaf = true;
            inOrderRank = 0;            
        }

        /**
         * @return the data
         */
        public int getData() {
            return data;
        }

        /**
         * @param data the data to set
         */
        public void setData(int data) {
            this.data = data;
        }

        /**
         * @return the parent
         */
        public bTreeNode getParent() {
            return parent;
        }

        /**
         * @param parent the parent to set
         */
        public void setParent(bTreeNode parent) {
            this.parent = parent;
        }

        /**
         * @return the left
         */
        public bTreeNode getLeft() {
            return left;
        }

        /**
         * @param left the left to set
         */
        public void setLeft(bTreeNode left) {
            this.left = left;
        }

        /**
         * @return the leftVisited
         */
        public Boolean getLeftVisited() {
            return leftVisited;
        }

        /**
         * @param leftVisited the leftVisited to set
         */
        public void setLeftVisited(Boolean leftVisited) {
            this.leftVisited = leftVisited;
        }

        /**
         * @return the right
         */
        public bTreeNode getRight() {
            return right;
        }

        /**
         * @param right the right to set
         */
        public void setRight(bTreeNode right) {
            this.right = right;
        }

        /**
         * @return the rightVisited
         */
        public Boolean getRightVisited() {
            return rightVisited;
        }

        /**
         * @param rightVisited the rightVisited to set
         */
        public void setRightVisited(Boolean rightVisited) {
            this.rightVisited = rightVisited;
        }

        /**
         * @return the isLeaf
         */
        public Boolean getIsLeaf() {
            return isLeaf;
        }

        /**
         * @param isLeaf the isLeaf to set
         */
        public void setIsLeaf(Boolean isLeaf) {
            this.isLeaf = isLeaf;
        }

        /**
         * @return the inOrderRank
         */
        public int getInOrderRank() {
            return inOrderRank;
        }

        /**
         * @param inOrderRank the inOrderRank to set
         */
        public void setInOrderRank(int inOrderRank) {
            this.inOrderRank = inOrderRank;
        }
        
        
    }
}
