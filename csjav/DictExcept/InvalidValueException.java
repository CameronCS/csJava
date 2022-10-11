/**
 * Thrown on <init> if there are more values than keys
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
public class InvalidValueException extends RuntimeException {
    /**
     * Constructs a new runtime exception with the specified detail message. 
     * The cause is not initialized, and may subsequently be initialized by a call to initCause.
     * @param s the detail message. The detail message is saved for later retrieval by the getMessage() method.
     */
    public InvalidValueException(String s) {
        super(s);
    }
}
