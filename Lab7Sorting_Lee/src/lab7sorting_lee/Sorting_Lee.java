package lab7sorting_lee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 28 OCT 2022 2300
 * Driver class for master menu 
 */
public class Sorting_Lee {

    //Bubble Sort
    static int[] bubbleSort(int[] importList) {
        //Copying list to different memory reference
        int[] sortList = importList.clone();

        Boolean swapped = true;
        while (swapped == true) {
            swapped = false;
            for (int i = 0; i < sortList.length - 1; i++) {
                if (sortList[i] > sortList[i + 1]) {
                    sortList = swapper(sortList, i, i + 1);
                    swapped = true;
                }
            }
        }
        return sortList;
    }

    //Insertion Sort
    static int[] insertionSort(int[] importList) {
        //Convert Array to ArrayList for easier manipulation
        ArrayList<Integer> tempImportList
                = (ArrayList<Integer>) Arrays.stream(importList).boxed().
                        collect(Collectors.toList());

        ArrayList<Integer> priorityQueue = new ArrayList();

        int temp;

        //Moving first element to priority queue
        priorityQueue.add(tempImportList.remove(0));

        while (!tempImportList.isEmpty()) {
            for (int i = 0; i < priorityQueue.size(); i++) {
                //Add at end of list
                if ((priorityQueue.get(i) < tempImportList.get(0)
                        && i == priorityQueue.size() - 1)
                        || priorityQueue.get(i) == tempImportList.get(0)) {
                    priorityQueue.add(i + 1, tempImportList.remove(0));
                    break;
                    //Slot into list
                } else if (priorityQueue.get(i) > tempImportList.get(0)) {
                    priorityQueue.add(i, tempImportList.remove(0));
                    break;
                }
            }
        }

// Array to return values 
        int[] sortList = new int[priorityQueue.size()];
        for (int i = 0; i < priorityQueue.size(); i++) {
            sortList[i] = priorityQueue.get(i);
        }
        return sortList;
    }

//selection sort
    static int[] selectionSort(int[] importList) {
        //Convert Array to Arraylist
        ArrayList<Integer> priorityQueue
                = (ArrayList<Integer>) Arrays.stream(importList).boxed().
                        collect(Collectors.toList());

//Array for returning the sorted values
        int[] sortedList = new int[importList.length];
//Setting current minimum and index to first element
        int currentMinimum = priorityQueue.get(0);
        int currentMinIndex = 0;
        int index = 0;
//Iterate until the ArrayList is empty
        while (!priorityQueue.isEmpty()) {
            currentMinimum = priorityQueue.get(0);
            for (int i = 0; i < priorityQueue.size(); i++) {
                //Set new minimum if there is a lower value
                if (priorityQueue.get(i) <= currentMinimum) {
                    currentMinimum = priorityQueue.get(i);
                    currentMinIndex = i;
                }
            }
            //Adds to sorted list in order
            sortedList[index] = priorityQueue.remove(currentMinIndex);
            index++;
        }
        return sortedList;
    }

    //Swaps element positions for bubble sort
    static int[] swapper(int[] importList, int swap1, int swap2) {
        int temp = importList[swap1];
        importList[swap1] = importList[swap2];
        importList[swap2] = temp;
        return importList;
    }
}
