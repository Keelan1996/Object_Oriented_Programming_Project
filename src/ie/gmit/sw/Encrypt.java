package ie.gmit.sw;

/**
 * @author Keelan Duddy
 * @version 1.0
 * @since 1.8
 * 
 * Encrypt class, inherits the getCracking method from Cypher
 * This class constructor takes a key and sentence
 * Depending on the key value, it will return a new string which it constucts by using a ceaser cypher, in turn encrypting it.
 */
public class Encrypt extends Cypher {

	private int key;
	private String sentance;
	private String encAnswer;

	// Constructor
	public Encrypt(int key, String sentence) {
		super();
		this.key = key;
		this.sentance = sentence;
	}

	// Getter
	public String getEncAnswer() {
		return encAnswer;
	}
	
	// Setter
	public void setEncAnswer(String encAnswer) {
		this.encAnswer = encAnswer;
	}

	// overriding Abstract Class method. This encrypts
	@Override
	public String getCracking() {
		// variable to store answer
		String encrypted = "";
		// variable to store characters
		char newChar;
		// Starting position on ascii table
		int startPos;
		// New position after
		int newPos;

		// looping through the received sentence
		for (char oneChar : sentance.toCharArray()) {
			// 32 is start of ascii table
			startPos = oneChar - 32;
			// adding the x amount (key) to shift
			newPos = (startPos + key);
			// cast a char and store
			newChar = (char) (32 + newPos);
			// append onto new string
			encrypted += newChar;
		}
		return encrypted;
	}
}
