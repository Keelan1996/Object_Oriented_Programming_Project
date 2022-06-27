package ie.gmit.sw;

import java.util.concurrent.*;

/**
 * @author Keelan Duddy
 * @version 1.0
 * @since 1.8
 * 
 * MapsToWork class, this class handles decryption requests
 * Implements the Callable interface
 * Once decryption is complete, it will return a future String, which populates a List in runner
 */
public class MapsToWork implements Callable<String> {
	
	// Private variables, assigned via constructor
	private int key;
	private String encryptedFile;
	
	// Constructor for the 'put maps to work' class
	public MapsToWork(int key, String encryptedFile) {
		super();
		this.key = key;
		this.encryptedFile = encryptedFile;
	}

	// Callable override, the threads will run this and return their attempts
	@Override
	public String call() throws Exception {
		Decrypt de = new Decrypt(key, encryptedFile);
		String ans = de.getCracking();
		return ans;
	}
}
