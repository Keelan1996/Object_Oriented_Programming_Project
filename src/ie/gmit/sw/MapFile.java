package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Keelan Duddy
 * @version 1.0
 * @since 1.8
 * 
 * MapFile class, this class is used to parse files.
 *It handles both the monogram file - returning a HashMap of characters and their probable occurences
 *It will also read in a local file (path specified by user)  and return it as a string
 */
public class MapFile {

	// NOTE: When I created my jar file. I changed the filePath to: "./monograms-ASCII-32-127.txt". Using the below path when in eclipse. .Jar now works!
	private String filePath = "src/ie/gmit/sw/monograms-ASCII-32-127.txt";
	private double probable;
	private HashMap<Character, Double> map = new HashMap<>();
	
	// This method will return a HashMap once the monogram file is parsed and probabilities are assigned - divided by 100d
	/**
	 * mapTheFile is used for parsing the monogram file
	 * @return Resturns a HashMap, containing english text characters and their probable occurrence values
	 */
	public HashMap<Character, Double> mapTheFile() {
		BufferedReader br = null;
		
		HashMap<Character, Double> tempMap = new HashMap<>();

		try {
			// Creating new file object
			File file = new File(filePath);
			// Buffered reader to read the text file
			br = new BufferedReader(new FileReader(file));
			// Variable just to store values
			String line = null;

			// Read file line by line
			while ((line = br.readLine()) != null) {
				if (line.startsWith(",")) continue;
				String[] parts = line.split(",");

				// Assign both values
				String myChar = parts[0].trim();
				String value = parts[1].trim();

				if (!myChar.equals("") && !value.equals("")) {
					// dividing the double entries by 100 to get their probable values
					probable = Double.parseDouble(value);
					map.put(myChar.charAt(0), probable/100d);
				}
			}
			// I skipped the ',' value as it would break the reader, had to add manually at end
			map.put(',', 0.00323418/100d);
			// Need to include a value for space also
			map.put(' ', 0.00189169/100d);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		tempMap = map;
		// return a copy of the mapped file
		return tempMap;
	}
	
	// This function will return a string from a local file. User MUST type in directory path to local file
	/**
	 * This function reads in a local file.
	 * @param filePath The string the user typed in, which should be a path directory string
	 * @return returns a new String of the file contents
	 * @throws FileNotFoundException Exception should file not be found
	 */
	public String readFile(String filePath) throws FileNotFoundException {
		
		// ../OOP_FinalProj/cypher.txt - was my input on console when option 4 is pressed
		
		StringBuilder builder = new StringBuilder();
		
		String sCurrentLn = "";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
		{
			while((sCurrentLn = br.readLine()) != null)
			{
				builder.append(sCurrentLn);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		// return whole file as a string
		return builder.toString();	
	}
}
