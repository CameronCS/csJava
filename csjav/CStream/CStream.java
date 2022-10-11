/** 
 * The new Input/Output Stream Static Library for Java
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
 * 
 */
package csjav.CStream;
import java.io.IOException;

import csjav.Array;
import csjav.CStream.CStreamExcept.DelayTypeInvalidException;
import csjav.CStream.CStreamExcept.StaticOnlyClassException;
/**
 * @author Cameron Stocks
 * @category Input/Output -> Console
 * @since 2022/09/26
 * @see java.io.IOException
 * @see csjav.CStream.CStreamExcept.StaticOnlyClassException
 * @see csjav.CStream.CStreamExcept.DelayTypeInvalidException
 */
public final class CStream {

    /**
     * Just making the Static only class exception a constant value
     */
    private static final String STATIC_ONLY_CLASS_EXCEP_MSG = (
        "This is made to be a static class. No instances of the class are allowed"
    );

//#region ()V-><init>

    /**
     * Constructor that ALWAYS throws an exception
     * {@see StaticOnlyClassException} 
     * @param b this is being used to differenciate between this constrcutor and the private one
     * @throws StaticOnlyClassException 
     */
    public CStream(boolean b) throws StaticOnlyClassException {
        if (b) {
            throw new StaticOnlyClassException(STATIC_ONLY_CLASS_EXCEP_MSG);
        } else if (!b) {
            throw new StaticOnlyClassException(STATIC_ONLY_CLASS_EXCEP_MSG);
        } else {
            throw new StaticOnlyClassException(STATIC_ONLY_CLASS_EXCEP_MSG);
        }
    }

    /**
     * Private constructor to allow native functions to work
     */
    private CStream() {}

//#endregion

//#region ()V->{Command Line Related}
    /**
     * Native method to clear the console
     */
    private native void Cclear();
    /**
     * clear allows the output Console to be cleared Command Line '{@code cls}'.
     */
    public static void clear() {
        new CStream().Cclear();
    }
    /**
     * native method to run a windows CLI command
     * @param CMD the command
     */
    private native void CrunCMD(String CMD);
    /**
     * runCMD allows a user to enter a {@code command line} to be executed.
     * @param CMD The command line to be run.
     */
    public static void runCMD(String CMD) {
        new CStream().CrunCMD(CMD);
    }

//#endregion

//#region ()V->pause();
    /**
     * Pauses the Console and waits for an {@code Enter} to be pressed.
     */
    public static void pause() {
        try {
            System.in.read(new byte[2]);
        } catch (IOException e) {}
    }
//#endregion

//#region (Z|C|B|S|I|J|F|D|Ljava/lang/Object)V->print

    /**
     * Prints a {@code boolean} to the console.
     * @param b the {@code boolean} to be printed.
     */
    public static void print(boolean b) {
        System.out.print(b);
    }
    /**
     * Prints a {@code char} to the console.
     * @param c the {@code char} to be printed.
     */
    public static void print(char c) {
        System.out.print(c);
    }
    /**
     * Prints a {@code byte} to the console.
     * @param b The {@code byte} to be printed.
     */
    public static void print(byte b) {
        System.out.print(b);
    }
    /**
     * Prints a {@code short} to the console.
     * @param s The {@code short} to be printed.
     */
    public static void print(short s) {
        System.out.print(s);
    }
    /**
     * Prints an {@code int} to the console.
     * @param i The {@code int} to be printed.
     */
    public static void print(int i) {
        System.out.print(i);
    }
    /**
     * Prints a {@code long} to the console.
     * @param l The {@code long} to be printed.
     */
    public static void print(long l) {
        System.out.print(l);
    }
    /**
     * Prints a {@code float} to the console.
     * @param f The {@code float} to be printed.
     */
    public static void print(float f) {
        System.out.println(f);
    }
    /**
     * Prints a {@code double} to the console
     * @param d The {@code double} to be printed
     */
    public static void print(double d) {
        System.out.println(d);
    }
    /**
     * Prints an {@code String} to the console.
     * @param s The {@code String} to be printed.
     */
    public static void print(String s) {
        System.out.println(s);
    }
    /**
     * Prints an {@code Object} to the console.
     * @param x The {@code Object} to be printed.
     */
    public static void print(Object x) {
        System.out.print(x);
    }

//#endregion

//#region (Z|C|B|S|I|J|F|D|Ljava/lang/Object)V->println
    /**
     * Prints a {@code boolean} to the console ending the print with a {@code \n}
     * @param b The
     */
    public static void println(boolean b) {
        System.out.println(b);
    }
    /**
     * Prints a {@code char} to the console ending the print with a {@code \n}
     * @param c The {@code char} to be printed
     */
    public static void println(char c) {
        System.out.println(c);
    }
    /**
     * Prints a {@code short} to the console ending the print with a {@code \n}
     * @param s The {@code short} to be printed 
     */
    public static void println(short s) {
        System.out.println(s);
    }
    /**
     * Prints a {@code int} to the console ending the print with a {@code \n}
     * @param i The {@code int} to be printed
     */
    public static void println(int i) {
        System.out.println(i);
    }
    /**
     * Prints a {@code long} to the console ending the print with a {@code \n} 
     * @param l The {@code long} to be printed 
     */
    public static void println(long l) {
        System.out.println(l);
    }
    /**
     * Prints a {@code float} to the console ending the print with a {@code \n}
     * @param f The {@code float} to be printed
     */
    public static void println(float f) {
        System.out.println(f);
    }
    /**
     * Prints a {@code double} to the console ending the print with a {@code \n}
     * @param d The {@code double} to be printed
     */
    public static void println(double d) {
        System.out.println(d);
    }
    /**
     * Prints an {@code String} to the console ending the print string with an {@code \n}.
     * @param x The {@code String} to be printed.
     */
    public static void println(String s) {
        System.out.println(s);
    }
    /**
     * Prints an {@code Object} to the console ending the print string with an {@code \n}.
     * @param x The {@code Object} to be printed.
     */
    public static void println(Object out) {
        System.out.println(out);
    }

//#endregion

//#region ()Ljava/lang/String->getLine();
    /**
     * Native method to get the line from the terminal
     * @param prompt the message sent to the stdout
     * @param newLine if newline is {@code true} the C++ DLL will include {@code std::cout << std::endl;} at the 
     * end of the prompt otherwise it will not
     * @return the string the user put in the stdin
     */
    private native String CStrIn(String prompt, boolean newLine);
    /**
     * Gets a {@code String} from input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static String getLine(String prompt, boolean newLine) {
        return new CStream().CStrIn(prompt.trim(), newLine);
    }
    /**
     * Gets a {@code String} from  user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @return The users Input
     */
    public static String getLine(String prompt) {
        return new CStream().CStrIn(prompt.trim(), true);
    }
    /**
     * Gets a {@code String} from input from the console
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static String getLine(boolean newLine) {
        return new CStream().CStrIn(null, newLine);
    }
    /**
     * Gets a {@code String} from user input from the console
     * @return The users Input
     */
    public static String getLine() {
        return new CStream().CStrIn(null, true);
    }

//#endregion

//#region ()Z->getBoolean;
    /**
     * Native method for the C++ DLL to get a boolean input by use of the {@code char} of the developers/users choice
     * @param prompt the message sent to the stdout
     * @param newLine if newline is {@code true} the C++ DLL will include {@code std::cout << std::endl;} at the 
     * end of the prompt otherwise it will not
     * @param char_true the character that will represent true
     * @param char_false the character that will represent false
     * @param err a message sent to the stdout if the user did not enter the {@code char_true} or the {@code char_false}
     * @return {@code true} or {@code false} depending on the user input
     */
    private native boolean CbooleanIn(String prompt, boolean newLine, char char_true, char char_false, String err);
    /**
     * Get a {@code boolean} input from the console by entering a char selected, then returning the adequate value
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @param char_true The {@code char} that will equal true
     * @param char_false The {@code char} that will equal true
     * @param err The error message to be printed when false is entered
     * @return {@code true} or {@code false} depending on the character entered
     */
    public static boolean getBoolean(String prompt, boolean newLine, char char_true, char char_false, String err) {
        return new CStream().CbooleanIn(prompt.trim(), newLine, char_true, char_false, err);
    }
    /**
     * Get a {@code boolean} input from the console by entering a char selected, then returning the adequate value
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @param char_true The {@code char} that will equal true
     * @param char_false The {@code char} that will equal true
     * @param err a message sent to the stdout if the user did not enter the {@code char_true} or the {@code char_false}
     * @return {@code true} or {@code false} depending on the character entered
     */
    public static boolean getBoolean(boolean newLine, char char_true, char char_false, String err) {
        return new CStream().CbooleanIn(null, newLine, char_true, char_false, err);
    }
    /**
     * Get a {@code boolean} input from the console by entering a char selected, then returning the adequate value
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @param char_true The {@code char} that will equal true
     * @param char_false The {@code char} that will equal true
     * @param err a message sent to the stdout if the user did not enter the {@code char_true} or the {@code char_false}
     * @return {@code true} or {@code false} depending on the character entered
     */
    public static boolean getBoolean(String prompt, char char_true, char char_false, String err) {
        return new CStream().CbooleanIn(prompt.trim(), true, char_true, char_false, err);
    }
    /**
     * Get a {@code boolean} input from the console by entering a char selected, then returning the adequate value
     * @param char_true The {@code char} that will equal true
     * @param char_false The {@code char} that will equal true
     * @param err a message sent to the stdout if the user did not enter the {@code char_true} or the {@code char_false}
     * @return {@code true} or {@code false} depending on the character entered
     */
    public static boolean getBoolean(char char_true, char char_false, String err) {
        return new CStream().CbooleanIn(null, true, char_true, char_false, err);
    }
//#endregion

//#region ()C->getChar();
    /**
     * Native method to get a char from the C++ Dll
     * @param prompt the message sent to the stdout
     * @param newLine if newline is {@code true} the C++ DLL will include {@code std::cout << std::endl;} at the 
     * end of the prompt otherwise it will not
     * @return a {@code char} 
     */
    private native char CcharIn(String prompt, boolean newLine);
    /**
     * Gets a {@code char} from user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static char getChar(String prompt, boolean newLine) {
       return new CStream().CcharIn(prompt.trim(), newLine); 
    }
    /**
     * Gets a {@code char} from user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @return The users Input
     */
    public static char getChar(String prompt) {
        return new CStream().CcharIn(prompt.trim(), true);
    }
    /**
     * Gets a {@code char} from user input from the console
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static char getChar(boolean newLine) {
        return new CStream().CcharIn(null, newLine);
    }
    /**
     * Gets a {@code char} from user input from the console
     * @return The users Input
     */
    public static char getChar() {
        return new CStream().CcharIn(null, true);
    }

//#endregion

//#region ()B->getByte();
    //NOTE: The byte uses typecasting from the int function.
    //It is only placed before int because it is smaller than an int
    /**
     * Gets a {@code byte} from user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static byte getByte(String prompt, boolean newLine) {
        return (byte)new CStream().CintIn(prompt.trim(), newLine);
    }
    /**
     * Gets a {@code byte} from user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @return The users Input
     */
    public static byte getByte(String prompt) {
        return (byte)new CStream().CintIn(prompt.trim(), true);
    }
    /**
     * Gets a {@code byte} from user input from the console
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static byte getByte(boolean newLine) {
        return (byte)new CStream().CintIn(null, newLine);
    }
    /**
     * Gets a {@code byte} from user input from the console
     * @return The users Input
     */
    public static byte getByte() {
        return (byte)new CStream().CintIn(null, true);  
    }

//#endregion

//#region ()S->getShort();
    //NOTE: The short uses typecasting from the int function. 
    //It is only placed before int because it is smaller than an int
    /**
     * Gets a {@code short} from user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static short getShort(String prompt, boolean newLine) {
        return (short)new CStream().CintIn(prompt.trim(), newLine);
    }
    /**
     * Gets a {@code short} from user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @return The users Input
     */
    public static short getShort(String prompt) {
        return (short)new CStream().CintIn(prompt.trim(), true);
    }
    /**
     * Gets a {@code short} from user input from the console
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static short getShort(boolean newLine) {
        return (short)new CStream().CintIn(null, newLine);
    }
    /**
     * Gets a {@code short} from user input from the console
     * @return The users Input
     */
    public static short getShort() {
        return (short)new CStream().CintIn(null, true);
    }

//#endregion

//#region ()I->getInt();
    /**
     * Get an int from the C++ dll
     * @param prompt the message sent to the stdout
     * @param newLine if newline is {@code true} the C++ DLL will include {@code std::cout << std::endl;} at the 
     * end of the prompt otherwise it will not
     * @return an {@code int}
     */
    private native int CintIn(String prompt, boolean newLine);
    /**
     * Gets a {@code int} from user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static int getInt(String prompt, boolean newLine) {
        return new CStream().CintIn(prompt.trim(), newLine);
    }
    /**
     * Gets a {@code int} from user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @return The users Input
     */
    public static int getInt(String prompt) {
        return new CStream().CintIn(prompt.trim(), true);
    }
    /**
     * Gets a {@code int} from user input from the console
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static int getInt(boolean newLine) {
        return new CStream().CintIn(null, newLine);
    }
    /**
     * Gets a {@code int} from user input from the console
     * @return The users Input
     */
    public static int getInt() {
        return new CStream().CintIn(null, true);
    }

//#endregion

//#region ()J->getLong();    
    /**
     * get a short from the C++ dll
     * @param prompt the message sent to the stdout
     * @param newLine if newline is {@code true} the C++ DLL will include {@code std::cout << std::endl;} at the 
     * end of the prompt otherwise it will not
     * @return a {@code long}
     */
    private native long ClongIn(String prompt, boolean newLine);
    /**
     * Gets a {@code long} from user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static long getLong(String prompt, boolean newLine) {
        return new CStream().ClongIn(prompt.trim(), newLine);
    }
    /**
     * Gets a {@code long} from user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @return The users Input
     */
    public static long getLong(String prompt) {
        return new CStream().ClongIn(prompt.trim(), true);
    }
    /**
     * Gets a {@code long} from user input from the console
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static long getLong(boolean newLine) {
        return new CStream().ClongIn(null, newLine);
    }
    /**
     * Gets a {@code long} from user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static long getLong() {
        return new CStream().ClongIn(null, true);
    }

//#endregion

//#region ()F->getFloat();
    /**
     * Get a float from the C++ Dll
     * @param prompt the message sent to the stdout
     * @param newLine if newline is {@code true} the C++ DLL will include {@code std::cout << std::endl;} at the 
     * end of the prompt otherwise it will not
     * @return a {@code float}
     */
    private native float CfloatIn(String prompt, boolean newLine);
    /**
     * Gets a {@code float} from the user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static float getFloat(String prompt, boolean newLine) {
        return new CStream().CfloatIn(prompt.trim(), newLine);
    }
    /**
     * Gets a {@code float} from the user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @return The users Input
     */
    public static float getFloat(String prompt) {
        return new CStream().CfloatIn(prompt.trim(), true);
    }
    /**
     * Gets a {@code float} from the user input from the console
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static float getFloat(boolean newLine) {
        return new CStream().CfloatIn(null, newLine);
    }
    /**
     * Gets a {@code float} from the user input from the console
     * @return The users Input
     */
    public static float getFloat() {
        return new CStream().CfloatIn(null, true);
    }

//#endregion

//#region ()D->getDouble();
    /**
     * Get a double from the C++ DLL
     * @param prompt the message sent to the stdout
     * @param newLine if newline is {@code true} the C++ DLL will include {@code std::cout << std::endl;} at the 
     * end of the prompt otherwise it will not
     * @return a {@code double}
     */
    public native double CdoubleIn(String prompt, boolean newLine);
    /**
     * Gets a {@code double} from the user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static double getDouble(String prompt, boolean newLine) {
        return new CStream().CdoubleIn(prompt.trim(), newLine);
    }
    /**
     * Gets a {@code double} from the user input from the console
     * @param prompt The {@code String} message printed before the input is Taken and ended with a {@code ": "}
     * @return The users Input
     */
    public static double getDouble(String prompt) {
        return new CStream().CdoubleIn(prompt.trim(), true);
    }
    /**
     * Gets a {@code double} from the user input from the console
     * @param newLine Determines whether the user input is taken in on a new line or on the same line
     * @return The users Input
     */
    public static double getDouble(boolean newLine) {
        return new CStream().CdoubleIn(null, newLine);
    }
    /**
     * Gets a {@code double} from the user input from the console
     * @return The users Input
     */
    public static double getDouble() {
        return new CStream().CdoubleIn(null, true);
    }
    //#endregion

    //#region printEachChar();
    /**
     * Print a string character by character to the stdout console
     * @param printStr the string to be printed
     * @param DelayMode a {@code char} that sends a token to the C++ dll stating the delay mode, NanoSeconds
     * milliSeconds, Seconds, minutes, hours
     * @param delayAmount The amount of time with respect to the {@code delayMode}
     * @param newLine whether or not to print the character on a new line
     */
    private native void CPrintCharDelay(String printStr, char delayToken, int delayAmount, boolean newLine);
    /**
     * Prints a String to the console
     * @param printString the string to be printed
     * @param DelayMode a {@code char} that sends a token to the C++ dll stating the delay mode, NanoSeconds
     * milliSeconds, Seconds, minutes, hours
     * @param delayAmount The amount of time with respect to the {@code delayMode}
     * @param newLine whether or not to print the character on a new line
     */
    public static void printEachChar(String printString, DelayType delayType, int delayAmount, boolean newLine) {
        if (delayType.getChar() == 0x00) {
            throw new DelayTypeInvalidException("Delay type can not be null");
        }
        new CStream().CPrintCharDelay(printString, delayType.getChar(), delayAmount, newLine);
    }
    /**
     * Prints a String to the console
     * @param printString the string to be printed
     * @param DelayMode a {@code char} that sends a token to the C++ dll stating the delay mode, NanoSeconds
     * milliSeconds, Seconds, minutes, hours
     * @param delayAmount The amount of time with respect to the {@code delayMode}
     */
    public static void printEachChar(String printString, DelayType delayType, int delayAmount) {
        if (delayType.getChar() == 0x00) {
            throw new DelayTypeInvalidException("Delay type can not be null");
        }
        new CStream().CPrintCharDelay(printString, delayType.getChar(), delayAmount, true);
    }
    //#endregion

    //#region printEachWord
    /**
     * Print each word at a delayed time
     * @param words A String array of each word to print
     * @param DelayMode a {@code char} that sends a token to the C++ dll stating the delay mode, NanoSeconds
     * milliSeconds, Seconds, minutes, hours
     * @param delayAmount The amount of time with respect to the {@code delayMode}
     * @param newLine whether or not to print the character on a new line
     */
    private native void CPrintWordDelay(String[] words, char delayToken, int delayAmount, boolean newLine);
    /**
     * Prints a string to the console using each single word
     * @param printString  the String to print
     * @param DelayMode a {@code char} that sends a token to the C++ dll stating the delay mode, NanoSeconds
     * milliSeconds, Seconds, minutes, hours
     * @param delayAmount The amount of time with respect to the {@code delayMode}
     * @param newLine whether or not to print the character on a new line
     */
    public static void printEachWord(String printString, DelayType delayType, int delayAmount, boolean newLine) {
        if (delayType.getChar() == 0x00) {
            throw new DelayTypeInvalidException("Delay type can not be null");
        }
        new CStream().CPrintWordDelay(getAllWords(printString), delayType.getChar(), delayAmount, newLine);
    }
    /**
     * Prints a string to the console using each single word
     * @param printString  the String to print
     * @param DelayMode a {@code char} that sends a token to the C++ dll stating the delay mode, NanoSeconds
     * milliSeconds, Seconds, minutes, hours
     * @param delayAmount The amount of time with respect to the {@code delayMode}
     */
    public static void printEachWord(String printString, DelayType delayType, int delayAmount) {
        if (delayType.getChar() == 0x00) {
            throw new DelayTypeInvalidException("Delay type can not be null");
        }
        new CStream().CPrintWordDelay(getAllWords(printString), delayType.getChar(), delayAmount, true);   
    }

    private static String[] getAllWords(String line) {
        Array<String> words = new Array<>();
        boolean wordFinished = false;
        boolean overwrite = false;
        String newWord = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '\n' || line.charAt(i) == '\t') {
                words.append(newWord);
                words.append(line.charAt(i) + "");
                overwrite = true;
                wordFinished = true;
                newWord = "";
            }
            
            if (!wordFinished) {
                if (line.charAt(i) != ' ') {
                    newWord += line.charAt(i);
                } else {
                    wordFinished = true;
                }
            }
            if ((wordFinished || i == line.length() - 1 ) && overwrite == false) {
                wordFinished = false;
                words.append(newWord);
                newWord = "";
            }
            if (overwrite) {
                overwrite = false;
                wordFinished = false;
            }
        }
        String[] retWords = new String[words.length()];
        for (int i = 0; i < words.length(); i++) { retWords[i] = words.valueOf(i); }
        return retWords;
    }

//#endregion

//#region Load Library
    /**
     * Loading the native Library
     */
    static { 
        java.io.File f = new java.io.File("csjav/CStream/CStreamDLL/CStream.dll");
        try {
            System.load(f.getAbsolutePath());
        } catch (UnsatisfiedLinkError e) {
            println("FATAL ERROR");
            print("Failed to load library\nPress enter to exit . . .");
            pause();
            System.exit(1);
        }
    }
//#endregion
}