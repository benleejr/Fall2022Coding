/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 25 NOV 2022
 * Blueprint for a single vertex object
 * Contains name and visited label
 */

//set integer value as vertex name/label
//Boolean for visited or not visited
class Vertex_Lee {
    char label;
    Boolean visited;
    
    Vertex_Lee(char label, Boolean visited) {
        this.label = label;
        this.visited = false;
    }
}