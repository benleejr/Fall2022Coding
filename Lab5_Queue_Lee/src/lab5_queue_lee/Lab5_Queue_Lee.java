package lab5_queue_lee;
/*
 * Name: Benedict Lee
 * Class: CSCI308-A-ADV DATA STRUCTURS,ALGORTHMS I, FALL 2022
 * Date: 13 SEP 2022 0934
 * Driver class for print queue
 */
import java.util.Objects;

public class Lab5_Queue_Lee {
    
    public static void main(String[] args) {        
        Queue_Lee list = new Queue_Lee();
        if (!Objects.isNull(list)) {
        UserInterface_Lee.Interface(list);
        } else {
            System.out.println("Error: There is a problem with the list.");
            System.exit(0);
        }    
    }    
}
