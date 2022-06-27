package ie.gmit.sw;

/**
 * @author Keelan Duddy
 * @version 1.0
 * @since 1.8
 * 
 * Abstract class, which models for programs using cyphering tools
 * 
 * See Decrypt
 * See Encrypt
 */
public abstract class Cypher implements Crackable {

	// classes that extend me will deal with/implement this method
	// Not a lot going on here either, I wanted to include an abstract class to demonstrate in UML
	public abstract String getCracking();
}