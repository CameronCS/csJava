/**
 * An exception if the delay type is null
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
package csjav.CStream.CStreamExcept;
/**
 * @author Cameron Stocks
 * @version 1.0.0
 * @since 11 October 2022
 */
public class DelayTypeInvalidException extends RuntimeException {
    /**
     * Constructs a new runtime exception
     *  with the specified detail message. The cause is not initialized, and may subsequently be
     *  initialized by a call to initCause.
     * @param arg0 message the detail message. The detail message is saved for later retrieval by the getMessage() method.
     */
    public DelayTypeInvalidException(String arg0) {
        super(arg0);
    }
}
