/**
 * Exception thrown if ther are duplicate keys
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
 * 
 */
package csjav.DictExcept;
/**
 * @author Cameron Stocks
 * @version 1.0.0
 */
public class DuplicateKeyException extends RuntimeException {
    /**
     * Constructs a new runtime exception with the specified detail message. 
     * The cause is not initialized, and may subsequently be initialized by a call to initCause.
     * @param s the detail message. The detail message is saved for later retrieval by the getMessage() method.
     */
    public DuplicateKeyException(String s) {
        super(s);
    }
}
