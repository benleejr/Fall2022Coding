/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 25 NOV 2022
 * User interface for interactive menu and driver
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInterface_Lee {

    static Graph_Lee graph = new Graph_Lee();
    static Traversal_Lee traverse = new Traversal_Lee();

    //Reads user input
    static void Interface() {
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int row = 0;
            String userInput = "";
            //Input accepts a vertex and its list of children to build the
            //adjacency list structure
            System.out.println("Please enter an alphabetical vertex label "
                    + "and its children. Press enter for each new vertex and "
                    + "its respective children. \nInput \"EX\" to complete "
                    + "entry.");
            while (true) {                
                userInput = br.readLine();
                if (userInput.equals("EX")) {
                    break;
                }
                char[] charArray = userInput.replace(" ", "").toCharArray();
                graph.Add(charArray, row);
                row++;
            }
            System.out.print("Input a character for selecting the starting "
                    + "vertex: ");
            char startVertex = br.readLine().charAt(0);
            
            System.out.println("DFS List");
            
            traverse.DFS(graph, startVertex);         
            traverse.resetGraph(graph);
            
            
            System.out.println("\n\nBFS List");
            traverse.BFS(graph, startVertex); 
            
            

        } catch (Exception e) {
            System.out.println("An unknown error occured, contact your administrator"
                    + " at 850 - 555 - 4000.");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Interface();
    }

    //END OF UserInterface_Lee.java
}
