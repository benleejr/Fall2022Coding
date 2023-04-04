/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 25 NOV 2022
 * Class to traverse the adjacency list using BFS and DFS
 */

import java.util.LinkedList;
import java.util.Stack;

class Traversal_Lee {

    //2 Stacks to store order nodes are visited in for BFS and DFS respectively    
    static Stack<Character> bfsStack = new Stack<>();
    static Stack<Character> dfsStack = new Stack<>();

    void StackPush(Stack<Character> stack, char vertexLabel) {
        stack.push(vertexLabel);
    }

    void PrintStack(Stack<Character> s) {
        if (s.isEmpty()) {
            return;
        }

        char x = s.peek();

        s.pop();

        PrintStack(s);

        if (!s.isEmpty()) {
            System.out.print(x);
        } else {
            System.out.print(x + ", ");
        }
    }

    void PrintBFSStack() {
        PrintStack(bfsStack);
    }

    //Methods for BFS and DFS
    void DFS(Graph_Lee graph, char vertexLabel) {
        int index = 0;

        for (int i = 0; i < graph.adjList.size(); i++) {
            if (graph.adjList.get(i).get(0).label == vertexLabel) {
                index = i;
                break;
            }
        }
        StackPush(dfsStack, vertexLabel);
        graph.adjList.get(index).get(0).visited = true;

        for (int j = 0; j < graph.adjList.get(index).size(); j++) {
            char targetVertex = graph.adjList.get(index).get(j).label;
            for (int i = 0; i < graph.adjList.size(); i++) {
                if (graph.adjList.get(i).get(0).label == targetVertex
                        && graph.adjList.get(i).get(0).visited == false) {
                    DFS(graph, targetVertex);
                    break;
                }
            }
        }
        PrintStack(dfsStack);

    }

    void resetGraph(Graph_Lee graph) {
        for (int i = 0; i < graph.adjList.size(); i++) {
            graph.adjList.get(i).get(0).visited = false;
        }
    }

    void BFS(Graph_Lee graph, char vertexLabel) {
        int index = 0;
        LinkedList<Vertex_Lee> queue = new LinkedList<>();
        //Finds vertex index in adjacency list
        for (int i = 0; i < graph.adjList.size(); i++) {
            if (graph.adjList.get(i).get(0).label == vertexLabel) {
                index = i;
                break;
            }
        }
        //Push vertex onto adjacency list
        if (graph.adjList.get(index).get(0).visited == false) {
            StackPush(bfsStack, graph.adjList.get(index).get(0).label);
            graph.adjList.get(index).get(0).visited = true;
        }

        //Add all neighbors onto queue
        for (int j = 1; j < graph.adjList.get(index).size(); j++) {
            queue.add(graph.adjList.get(index).get(j));
        }
        //Check each neighbor if visited
        for (int i = 0; i < graph.adjList.size(); i++) {

            for (int j = 0; j < queue.size(); j++) {
                if (graph.adjList.get(i).get(0).label == queue.get(j).label
                        && graph.adjList.get(i).get(0).visited == true) {
                    queue.remove(j);
                }
                if (!queue.isEmpty()
                        && graph.adjList.get(i).get(0).label == queue.get(j).label
                        && graph.adjList.get(i).get(0).visited == false) {
                    StackPush(bfsStack, queue.get(j).label);
                    graph.adjList.get(i).get(0).visited = true;
                }

            }
        }
        if (!queue.isEmpty()) {
            queue.remove();
            if (!queue.isEmpty()) {
                BFS(graph, queue.get(0).label);
            }
        }

        PrintStack(bfsStack);
    }
//END OF Traversal_Lee
}
