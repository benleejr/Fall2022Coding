/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 25 NOV 2022
 * Contains the adjacency list representation of the graph
 */

import java.util.ArrayList;

//Contains the adjacency list structure
class Graph_Lee {

    ArrayList<ArrayList<Vertex_Lee>> adjList = new ArrayList<>();

    //Add to adjacency list
    void Add(char[] label, int row) {

        //Allocate new row
        for (int i = 0; i < label.length; i++) {
            Vertex_Lee vertex = new Vertex_Lee(label[i], false);
             //If the list has no rows or if adding to a new row
            if (adjList.isEmpty()) {
                adjList.add(new ArrayList<>());
            } else if (row + 1 > adjList.size()) {
                adjList.add(new ArrayList<>());
            }
            adjList.get(row).add(vertex);
        }     
    }
    //End of Graph_Lee.java
}
