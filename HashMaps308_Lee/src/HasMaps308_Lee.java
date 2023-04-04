/*
    
    Benedict Lee
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class HasMaps308_Lee {
    public static void main(String[] args) {
        
        // Declaring a HashMap
        HashMap<Integer, String> HashMap308 = new HashMap<>();
        
        //Adding elements to HashMap - use HashMap308.put(12, "");
        //Add 13 elements to the HashMap
        HashMap308.put(0, "Eclairs");
        HashMap308.put(1, "Noodles");
        HashMap308.put(2, "Chicken");
        HashMap308.put(3, "Beef");
        HashMap308.put(4, "Tea");
        HashMap308.put(5, "Lobster");
        System.out.println("");
        
        //Display content using Iterator
        Set set = HashMap308.entrySet();
        Iterator iterator = set.iterator();
        
        //Print out all key/values
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.println("Key is: " + mentry.getKey() + " & Value is: "
                    + mentry.getValue());
        } //Get values based on key: String var = HashMap308.get(--keyhere--);
        // add 3 elements references to a record in the HasMap. Print them after
        
        System.out.println("We are retrieving the key and value from the HashMap"
                + " to practice using the get() function");
        System.out.println("Value is: " + HashMap308.get(0) + "\nKey is: 0");
        System.out.println("Value is: " + HashMap308.get(3) + "\nKey is: 3");
        System.out.println("Value is: " + HashMap308.get(4) + "\nKey is: 4");
        System.out.println("");
        
        //Remove values based on key: HashMap308.remove(--keyhere--);
        //Remove 3 of your values here using the key.
        //Print out the one you plan to remove beforehand
        
        System.out.println("The items to be removed are: ");
        System.out.println("Value is: " + HashMap308.get(0) + "\nKey is: 0");
        System.out.println("Value is: " + HashMap308.get(1) + "\nKey is: 1");
        System.out.println("Value is: " + HashMap308.get(2) + "\nKey is: 2");
        System.out.println("");
        
        HashMap308.remove(0);
        HashMap308.remove(1);
        HashMap308.remove(2);
        
        //Replace values based on key: oldValue = HashMap308.replace(1, "");
        //Updating 3 values using the key
        //Print out a before and after. Note: replace returns old value
        //Can save it in a variable and easily print a before and after
        
        System.out.println("We are replacing values here:");
        String oldValue = HashMap308.replace(3, "Talibut");
        System.out.println("Value at Key 3 before replacement: " + oldValue +
                "\nValue after: " + HashMap308.get(3));
        oldValue = HashMap308.replace(4, "Wellington");
        System.out.println("Value at Key 4 before replacement: " + oldValue + 
                "\nValue after: " + HashMap308.get(4));
        oldValue = HashMap308.replace(5, "Crab");
        System.out.println("Value at Key 5 before replacement: " + oldValue + 
                "\nValue after: " + HashMap308.get(5));
        
        //Print out the map after removing and replacing the records
        System.out.println("Map key and values after removal/replace: ");
        
        Set set2 = HashMap308.entrySet();
        
        Iterator iterator2 = set2.iterator();
        
        //Print out all of the key/values again
        while (iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry) iterator2.next();
            System.out.println("Key is: " + mentry2.getKey() + " & Value is: "
                    + mentry2.getValue());
        }
        
    } //end main
} //end HashMaps308 class
