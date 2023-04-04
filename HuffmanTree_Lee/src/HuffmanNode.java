import java.util.Comparator;

/**
 *
 * @author bened
 */

class HuffmanNode {
    
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare (HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}
