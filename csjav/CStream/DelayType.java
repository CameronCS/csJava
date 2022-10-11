/**
 * This is the type of delay the API will use for the PrintEach{opt}() method
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
package csjav.CStream;
/**
 * @author Cameorn Stocks
 * @version 1.0.0
 * @since 11 Ocotber 2022
 */
public enum DelayType {
    /**
     * These are the enum values
     */
    NanoSeconds,
    MilliSeconds,
    Seconds,
    Minutes,
    Hours;

    /**
     * the getChar is the enums method of giving the token from developer using this API to the native CStream DLL
     * @return the Token of the choice
     */
    public char getChar() {
        switch(this) {
            case NanoSeconds: return 'n';
            case MilliSeconds: return 'z';
            case Seconds: return 's';
            case Minutes: return 'm';
            case Hours: return 'h';
        }
        return 0x00;
    }
}