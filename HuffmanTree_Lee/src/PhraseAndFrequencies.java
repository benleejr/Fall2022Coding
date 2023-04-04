import java.util.ArrayList;

/**
 *
 * @author bened
 * Holds and updates distinct character and associated frequencies
 */

public class PhraseAndFrequencies {
    //Contains all distinct character in order of appearance
    ArrayList<Character> distinctChars = new ArrayList<>();
    //Contains frequencies associated with each character above
    ArrayList<Integer> frequencies = new ArrayList<>();
    
    public void AddCharacter (char ch) {
        //For a a new distinct character, we need to add it to the distinctChars
        //array we also need to initialize its frequency in the frequencies array
        // to 1
        
        distinctChars.add(ch);
        frequencies.add(1);
    }
    
    public void UpdateFrequency (char ch) {
        //For an existing character, we need to obtain the location of the
        //character in distinctChars, then increment the associated frequency by
        //1 in frequencies
        int loc = distinctChars.indexOf(ch);
        int freq = frequencies.get(loc);
        frequencies.set(loc, freq + 1);
    }
    
    public int checkCharacter (char ch) {
        //returns index of -1 if not in list
        return distinctChars.indexOf(ch);
    }
    
    public void printArrays() {
        //Prints both arrays for error checking and quality control purposes
        System.out.println(distinctChars);
        System.out.println(frequencies);
    }
}
