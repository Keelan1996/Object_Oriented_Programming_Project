package ie.gmit.sw;

import java.util.HashMap;

/**
 * @author Keelan Duddy
 * @version 1.0
 * @since 1.8
 * 
 * CharOccurrence class, this class takes in a string and returns a HashMap.
 * The string gets broken down into an array and in turn gets stored to a new HashMap, which then gets returned.
 */
public class CharOccurrence {
	
    // Creating a HashMap containing char
    // as a key and occurrences as  a value
	private HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
	
	// This method will return a map of character occurrences
	/**
	 * This function is used to count the common characters within a string
	 * @param inputString
	 * @return Returns a HashMap, containing characters and their occurrences
	 */
    public HashMap<Character, Integer> characterCount(String inputString)
    {
        // Converting given string to char array
        char[] strArray = inputString.toCharArray();
        // Temp map to send, protect local data
        HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>();
 
        // checking each char of strArray
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else {
                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap.put(c, 1);
            }
        }
        tempMap = charCountMap;
        // Returning a copy
        return tempMap;
    }
}
