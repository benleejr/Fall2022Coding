package lab6_minmaxheap_lee;

import java.util.Objects;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 10 OCT 2022 0850
 *  Driver class for heap
 */

public class Lab6_MinMaxHeap_Lee {

    public static void main(String[] args) {
        HeapManagement_Lee tree = new HeapManagement_Lee();
        if (!Objects.isNull(tree)) {
            UserInterface_Lee.Interface(tree);
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }
    }
}
