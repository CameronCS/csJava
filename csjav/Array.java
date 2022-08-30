/**
 * The Array class is here to make arrays more simple and easier to understand
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
 * 
 * 
 * 
 * 
 */

package csjav;

import java.util.Iterator;
import java.util.NoSuchElementException;
import csjav.ArrayExceptions.NoDuplicateValueException;
/**
 * @author Cameron Stocks
 * @version 1.0.0
 * @see java.lang.Iterable
 * @see java.util.Iterator
 * @apiNote The Array<T> class allows for {@code for each loop}
 * @apiNote If the use of primitive datatypes is wanted the wrapper class is to be used
 */
public class Array<T> implements Iterator<T>, Iterable<T> {
    /**
     * @serialField {@code Generic Array}
     */
    private T[] arr;
    /**
     * @serialField {@code len} stands for {@code length}
     */
    private int len;
    /**
     * @serialField the last index of the array {@code this.len - 1}
     */
    private int lastIndex; 
    /**
     * @serialField {@code currentIndex} used for the {@link java.lang.Iterator} and {@link java.util.Iterable}
     */
    private int currentIndex;

    /**
     * @serialField {@code IndexOutOfBoundsException} message
     */
    private final String indexOutE = "Index <%d> out of bounds of new length <%d>";
    /**
     * @serialField {@code NoSuchElementException} message
     */
    private final String noSuchElE = "Item <%s> does not exist";
    /**
     * @serialField {@code NoDuplicateValueException} message
     * @see csjav.ArrayExceptions.NoDuplicateValueException
     */
    private final String NoDupeVal = "No Duplicate value present";

    //Costructors
    /** 
     * This is the default constructor for the {@code Array<T>} class that initilises the {@code Array<T>} classes values
     * to default values
    */
    @SuppressWarnings("unchecked")
    public Array() {
        this.arr = (T[])new Object[0];
        this.len = 0;
        this.lastIndex = -1;
        this.currentIndex = 0;
    }

    /**
     * The Parameterised Constructor that initilises the componants in the {@code Array<T>} class
     * @param arr this is the default array that gets passed into the {@code Array<T>} class
     */
    public Array(T[] arr) {
        this();
        this.arr = arr;
        this.len = arr.length;
        this.lastIndex = this.len - 1;
    }

    /**
     * This constructor takes in an {@code Array<T>} class as the main parameter. 
     * This allows for the default fields for the previous {@code Array<T> class} to be constructed in the new class
     * @param arr the {@code Array<T>} class passed as an argument to convert the values across
     */
    public Array(Array<T> arr) {
        this();
        this.arr = arr.arr;
        this.len = arr.len;
        this.lastIndex = arr.lastIndex;
    }

    //
    // Array Manipulation
    //

    /**
     * The appened method adds a new item to the back of the {@code Array<T>} class 
     * @param item the item being appened to the array
     */
    @SuppressWarnings("unchecked")
    public void append(T item) {
        T[] t = this.arr;
        this.len++;
        this.lastIndex = this.len - 1;
        this.arr = (T[])new Object[this.len];
        for (int i = 0; i < t.length; i++) {
            this.arr[i] = t[i];
        }
        this.arr[this.len - 1] = item;
    }

    /**
     * Appends a general array to the back of the {@code Array<T>} class 
     * @param lst a general array to be added to the array class
     */
    public void append(T[] lst) {
        for (T item: lst) {
            this.append(item);
        }
    }

    /**
     * This append method will add the new items to the back of the {@code Array<T>} class
     * @param items an {@code Array<T>} class that will be added
     */
    public void append(Array<T> items) {
        for (T item: items) {
            this.append(item);
        }
    }

    /**
     * This adds a specific item at a specifc index in the {@code Array<T>} class
     * @param index the index the item is to be set at
     * @param item the item to be added at that index
     * @throws
     * IndexOutOfBoundsException if the index is greater than the length or less than 0
     */
    @SuppressWarnings("unchecked")
    public void insertAt(int index, T item) {
        if (index == this.len) {
            this.append(item);
            return;
        } else if (index > this.len) {
            throw new IndexOutOfBoundsException(
                String.format(
                    this.indexOutE,
                    index,
                    this.len
                )
            );
        }
        T[] t = this.arr;
        this.len = 0;
        this.arr = (T[])new Object[0];
        for (int i = 0; i < index; i++) {
            this.append(t[i]);
        }
        this.append(item);
        for (int i = index; i < t.length; i++) {
            this.append(t[i]);
        }
    }

    /**
     * Removes the item at the specific index
     * @param index the index of the item to be removed
     * @throws 
     * IndexOutOfBoundsException if the index is greater than the length or less than 0
     */
    @SuppressWarnings("unchecked")
    public void remove(int index) {
        if (index > this.len) {
            throw new IndexOutOfBoundsException(
                String.format(
                    this.indexOutE, 
                    index,
                    this.len
                )
            );
        }
        T[] t = this.arr;
        this.len--;
        this.lastIndex = this.len - 1;
        this.arr = (T[]) new Object[this.len];
        for (int i = 0, k = 0; i < t.length; i++) {
            if (i != index) {
                this.arr[k] = t[i];
                k++;
            }
        }
    }

    /**
     * Removes the first instance of the item in the array 
     * @param item the item to be removed from the array
     * @throws
     * NoSuchElementException if the item is not present
     */
    public void remove(T item) {
        int index = this.indexOf(item);
        if (index == -1) {
            throw new NoSuchElementException(
                String.format(
                    this.noSuchElE,
                    item
                )
            );
        }
        this.remove(index);
    }

    /**
     * Removes values from the {@code Array<T>} class
     * @param arr the array of values to be removed
     * @throws
     *  NoSuchElementException if the element is not found
     */
    public void remove(T[] arr) {
        for (T elem: arr) this.remove(elem);   
    }

    /**
     * Removes values from specific indices in the {@code Array<T>} class
     * @param indices the array of indices to be removed
     * @throws 
     * IndexOutOfBoundsException if one of the indices is greater than the length
     */
    public void remove(int[] indices) {
        Array<T> rem = this;
        for (int index: indices) {
            if (index > this.lastIndex || index < 0) {
                throw new IndexOutOfBoundsException(
                    String.format(
                        this.indexOutE, 
                        index,
                        this.len
                    )
                );
            }
            rem.append(this.valueOf(index));
        }
        for (T elem: rem) this.remove(elem);
    }

    /**
     * Removes an {@code Array<T>} class set of elements from the{@code Array<T>} class 
     * @param arr an Instance of the {@code Array<T>} class to remove said elements
     * @throws 
     * NoSuchElementException if the element is not present
     */
    public void remove(Array<T> arr) { 
        for (T elem: arr) {
            this.remove(elem);
        }
    }

    /**
     * Removes an item from the array and returns it to the user
     * @param index the index of the element to be removed
     * @return the element removed
     * @throws 
     * IndexOutOfBoundsException if the index given is greater than the length or less than 0
     */
    public T pop(int index) {
        if (index > this.len && index < 0) {
            throw new IndexOutOfBoundsException(
                String.format(
                    this.indexOutE,
                    index,
                    this.len
                )
            );
        }
        T elem = this.valueOf(index);
        this.remove(index);
        return elem;
    }

    /**
     * Edits a specific value in the {@code Array<T>} class
     * @param index the index of the item to edit
     * @param value the new value to replace the old value
     * @throws
     * IndexOutOfBoundsException if the index is greater than the length or less than 0
     */
    public void edit(int index, T value) {
        if (index > this.lastIndex || index < 0) {
            throw new IndexOutOfBoundsException(
                String.format(
                    this.indexOutE, 
                    index,
                    this.len
                )
            );
        }
        this.arr[index] = value;
    }

    /**
     * Get a specific index of an item
     * @param item the item to search for in the array
     * @return the {@code index} of the item is found and {@code -1} if the item is not found
     */
    public int indexOf(T item) {
        int returnIndex = -1;
        boolean found = false;
        for (int i = 0; i < this.length(); i++) {
            if (this.valueOf(i).equals(item)) {
                if (!found) {
                    returnIndex = i;
                    found = true;
                }
            }
        }
        return returnIndex;
    }

    /**
     * Get the value of a specific index
     * @param index the index of the item
     * @return the value at that index
     * @throws
     * IndexOutOfBoundsException if the index is greater than the length or less than 0
     */
    public T valueOf(int index) {
        if (index > this.lastIndex || index < 0) {
            throw new IndexOutOfBoundsException(
                String.format(
                    this.indexOutE,
                    index,
                    this.len
                )
            );
        }
        return this.arr[index]; 
    }

    /**
     * Get the length of the {@code Array<T>} class
     * @return the length
     */
    public int length() { return this.len; }

    /**
     * Get the last item of the {@code Array<T> class}
     * @return the last item
     */
    public T getLastItem() { return this.valueOf(this.lastIndex); }

    /**
     * Check to see if the {@code Array<T>} class contains a specific value
     * @param item the item to be checked for
     * @return {@code true} or {@code false} dependant on whether or not the item is in the class
     */
    public boolean contains(T item) {
        return this.indexOf(item) == -1 ? false : true;
    }

    @Override @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (!(obj instanceof Array)) return false;
        Array<T> cObj = (Array<T>)obj;

        if (this.length() != cObj.length()) return false;

        boolean isEqual = true;
        for (int i = 0; i < this.length(); i++)
            if (!(this.valueOf(i).equals(cObj.valueOf(i))) && isEqual) isEqual = false;
        return isEqual;
    }

    /**
     * The {@code repr} method gives a String representaton of the class showing the elements and and indices
     * @return the String representaion of the {@code Array<T>} class
     */
    public String repr() {
        String toStr = (
            "Class <" + this.getClass() + ">\n" +
            "Length[" + this.len + "]\n" +
            "Last Index[" + this.lastIndex + "]\n"
        ); 

        for (int i = 0; i < this.length(); i++) {
            toStr += "Element <" + this.valueOf(i) + "> | index : [" + i + "] | Position[" + (i + 1)  + "]\n";
        }
        return toStr; 
    }

    /**
     * Call the "{@code toString()}" method of a specific element in the class 
     * @param index the index of the element to call
     * @return the String representation of the element
     * @throws 
     * IndexOutOfBoundsException if the index is greater then the length or less than 0
     */
    public String elemToStr(int index) {
        if (index > this.lastIndex || index < 0) {
            throw new IndexOutOfBoundsException(
            String.format(
                    this.indexOutE, 
                    index,
                    this.len
                )   
            );
        }
        T elem = this.valueOf(index);
        return elem.toString();
    }


    /**
     * Check for duplicate values
     * @return {@code true} or {@code false} depending on whether or not a duplicate value is found
     */
    public boolean DuplicateValues() {
        boolean dupe = false;
        for (T val: this.arr) {
            int count = 0;
            for (T val2: this.arr) {
                if (val.equals(val2)) count++;
                if (count == 2) dupe = true;
            }
        }
        return dupe;
    }

    /**
     * Returns the first instance of a duplicate value
     * @return the duplicate method
     * @throws
     * NoDuplicateValueException if there is non duplicate value
     */
    public T getDuplicateItem() {
        if (!this.DuplicateValues()) {
            throw new NoDuplicateValueException(this.NoDupeVal);
        }

        for (T val1: this.arr) {
            int count = 0;
            for (T val2: this.arr) {
                if (val1.equals(val2)) count++;
                if (count == 2) return val1;
            }
        }
        return null;
    }

    /**
     * Checks to see if the element at a specific index is equal to an object
     * @param index the index of the value to compare
     * @param obj the object for comparison
     * @return {@code true} or {@code false} depending on whether or not the element is equal to the object
     * @throws
     * IndexOutOfBoundsException if the index is greater than the length or less than 0
     */
    public boolean elemEquals(int index, T obj) {
        if (index > this.len || index < 0) {
            throw new IndexOutOfBoundsException(
                String.format(
                    this.indexOutE, 
                    index,
                    this.len
                )
            );
        }
        T elem = this.valueOf(index);
        return elem.equals(obj);
    }

    //
    // Iterator methods
    //
    @Override
    public boolean hasNext() {
        return this.currentIndex < this.len;
    }

    @Override
    public T next() {
        return this.hasNext() ? this.valueOf(this.currentIndex++) : null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Array<T>(this.arr);
    }
}