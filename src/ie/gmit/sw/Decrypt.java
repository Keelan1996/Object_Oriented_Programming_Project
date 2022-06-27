package ie.gmit.sw;

/**
 * @author Keelan Duddy
 * @version 1.0
 * @since 1.8
 * 
 * Decrypt class, inherits the getCracking method from Cypher
 * This class constructor takes a key and sentence which is encrypted
 * Depending on the key value, it will return a new string which it constucts by using a ceaser cypher
 */
public class Decrypt extends Cypher {

	private int key;
	private String sentance;

	// Constructor
	public Decrypt(int key, String sentence) {
		super();
		this.key = key;
		this.sentance = sentence;
	}

	// overriding Abstract Class method. This decrypts
	@Override
	public String getCracking() {
		// variable to store answer
		String decrypted = "";
		// variable to store characters
		char newChar;
		// Starting position on ascii table
		int startPos;
		// New position after
		int newPos;

		// looping through the recieved sentence
		for (char oneChar : sentance.toCharArray()) {
			// 32 is start of ascii table
			startPos = oneChar - 32;
			// This time we minus the key
			newPos = (startPos - key);
			// Ensuring we don't go outside of scope on table
			// Above min
			if (newPos >= 0) {
				// 32 is the start of table
				newChar = (char) (newPos + 32);
			} else {
				// 127 is end of table
				newChar = (char) (newPos + 127);
			}
			// append onto new string
			decrypted += newChar;
		}
		return decrypted;
	}

}
