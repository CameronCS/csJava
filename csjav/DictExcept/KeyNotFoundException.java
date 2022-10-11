/**
 * Exception thrown if the key is not found
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
package csjav.DictExcept;
/**
 * @author Cameron Stocks
 * @version 1.0.0
 */
public class KeyNotFoundException extends RuntimeException {
    /**
     * Constructs a new runtime exception with the specified detail message. 
     * The cause is not initialized, and may subsequently be initialized by a call to initCause.
     * @param s the detail message. The detail message is saved for later retrieval by the getMessage() method.
     */
    public KeyNotFoundException(String s) {
        super(s);
    }
}
