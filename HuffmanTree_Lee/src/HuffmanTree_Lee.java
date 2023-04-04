import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author bened
 */
public class HuffmanTree_Lee {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        PhraseAndFrequencies PF = new PhraseAndFrequencies();
        
        PF.distinctChars = new ArrayList<>();
        PF.frequencies = new ArrayList<>();
        
        UserInterface.ObtainCharacters(PF);
        PF.printArrays();
        
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(PF.distinctChars.size()
        ,new MyComparator());
        
        AddToQueue(q, PF);
        
        //create a root note
        HuffmanNode root = null;
        
        root = ExtractNodes(q, root);
        
        UserInterface.printCode(root, "");
    }
    
    //This method creates a Huffman node object and adds it to the priority queue
    public static void AddToQueue(PriorityQueue<HuffmanNode> q, PhraseAndFrequencies PF) {
        for (int i = 0; i < PF.distinctChars.size(); i++) {
            HuffmanNode hn = new HuffmanNode();
            
            hn.c = PF.distinctChars.get(i);
            hn.data = PF.frequencies.get(i);
            
            hn.left = null;
            hn.right = null;
            
            //add functions, adds the huffman node to the queue
            q.add(hn);
        }
    }
    
    //This method traverses the heap and extracts the two minimum values from the
    //heap each time until its size reduces to 1, extract until all the nodes are
    //extracted. The path of the traversal determines the code for that character.
    public static HuffmanNode ExtractNodes (PriorityQueue<HuffmanNode> q, 
            HuffmanNode root) {
        while (q.size() > 1) {
            //first min extract
            HuffmanNode x = q.peek();
            q.poll();
            
            //second min extract
            HuffmanNode y = q.peek();
            q.poll();
            
            //new node f which is equal to the sum of the frequency of the two
            //nodes assigning values to the f node
            HuffmanNode f = new HuffmanNode();            
            f.data = x.data + y.data;
            f.c = '-';
            //first extracted node as left child
            f.left = x;
            //second extracted node as the right child
            f.right = y;
            //marking the f node as the root node.
            root = f;
            //add this node to the priority-queue
            q.add(f);
        }
        return root;
    }
}//end HuffmanTree_Lee class
