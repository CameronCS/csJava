/**
 * Exception thrown if there are no duplicate values
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
package csjav.ArrayExceptions;

/**
 * @author Cameron Stocks
 * @version 1.0.0
 * @since 10 October 2022
 */
public class NoDuplicateValueException extends RuntimeException {
    /**
     * Constructs a new runtime exception with the specified detail message. \
     * The cause is not initialized, and may subsequently be initialized by a call to initCause.
     * @param arg0 the detail message. The detail message is saved for later retrieval by the getMessage() method.
     */
    public NoDuplicateValueException(String arg0) {
        super(arg0);
    }
}
