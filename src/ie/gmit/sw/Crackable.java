package ie.gmit.sw;

/**
 * @author Keelan Duddy
 * @version 1.0
 * @since 1.8
 * 
 * Interface, which models for programs using cyphering tools
 * 
 * See Cypher
 */
public interface Crackable {
	
	// Abstract class will collect this
	// Not a lot going on here, I wanted to include an interface to demonstrate in UML
	/**
	 * This function is polymorphic, the two classes that instantiate this method
	 * do two different things: either Encrypt or Decrypt
	 * 
	 * @return this will return a string of encrypted or decrypted data
	 */
	public String getCracking();
}
