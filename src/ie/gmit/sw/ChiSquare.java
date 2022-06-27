package ie.gmit.sw;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * @author Keelan Duddy
 * @version 1.0
 * @since 1.8
 * 
 * ChiSquare class, this class implements the callable interface, in order to return values from a thread.
 * <b>It is important to note, this class is not working as intended</b>
 * It's functionality works to the most part, the issues lies with returning the future double values back to the Runner
 * WIP
 */
public class ChiSquare implements Callable<Double>{
	
	private int key;
	private String encryptedFile;
	Map<Character, Double> expected;
	Map<Character, Integer> occurrences;

	// Constructor
	public ChiSquare(int key, String encryptedFile, Map<Character, Double> expected,
			Map<Character, Integer> occurrences) {
		super();
		this.key = key;
		this.encryptedFile = encryptedFile;
		this.expected = expected;
		this.occurrences = occurrences;
	}

	// This class is not working entirely, I can't seem to return the future double values
	/**
	 * call() will return a future value
	 */
	@Override
	public Double call() throws Exception {
		
		double result = 0.0;
		double occVal;
		double expVal;
		double calcVal;
		double tally;
		
		for (Character c : occurrences.keySet())
		{
			// calculations to retrieve "possible" key
			occVal = occurrences.get(c);
			expVal = expected.get(c);
			calcVal = expVal * encryptedFile.length();
			tally = (occVal - calcVal) * (occVal - calcVal) / calcVal;
			result += tally;
			// Working here??? 
			System.out.println("Value: " + result);
		}
		// returning the future result
		return result;
	}

}
