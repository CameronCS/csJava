/**
 * The Dictionary class will map values specific to a key ("index") within the clas
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

import csjav.DictExcept.InvalidValueException;
import csjav.DictExcept.KeyNotFoundException;
import csjav.DictExcept.DuplicateKeyException;
import java.util.Iterator;
/**
 * @author Cameron Stocks
 * @version 1.0.0
 * @see csjav.Array
 * @see java.lang.Iterable
 * @see java.util.Iterator
 * @see csjav.DictExcept.InvalidValueException
 * @see csjav.DictExcept.KeyNotFoundException
 * @see csjav.DictExcept.DuplicateKeyException
 * @apiNote The Dictionary<Key, Val> class allows for {@code for each loop} with {@code Keys} & {@code Values}
 * @apiNote If the use of primitive datatypes is wanted the wrapper class is to be used
 */
public class Dictionary<Key, Val> {
    /**
     * @serialField The keys in the dictionary
     */
    private Array<Key> kArr;
    /**
     * @serialField the values in the dictionary
     */
    private Array<Val> vArr;
    /**
     * @serialField the length of keys to values in the dictionary
     */
    private int len;

    //#region Static exception strings
    private static final String InKeyEx = "Key length <%d> can not be greater than Value length<%d>";
    private static final String InValEx = "Value length <%d> can not be greater than Key length<%d>";
    private static final String DupKeyE = "Key <%s> already exists";
    private static final String KeyDNEE = "Key <%s> does not exist";
    //#endregion

    /**
     * @serialField The Keys of the Dictionary
     */
    public KeyIterator Keys;
    /**
     * @serialField The Vales of the Dictionary
     */
    public ValueIterator Values;
    /**
     * Creates a blank instance of the class
     */
    public Dictionary() {
        this.kArr = new Array<>();
        this.vArr = new Array<>();
        this.len = 0;
        this.Keys = new KeyIterator();
        this.Values = new ValueIterator();
    }
    /**
     * The constructor of the class that has one value for the constructor
     * @param key The key for the value
     * @param val The value set into the array
     */
    public Dictionary(Key key, Val val) {
        this();
        this.kArr.append(key);
        this.vArr.append(val);
        this.len = this.kArr.length();
    }
    /**
     * This constructor takes in an array of keys and an array of values to initilise the dictionary.
     * See
     * {@link csjav.Array} for additional information
     * @param keys An {@code Array<T>} of keys entered into the Dictionary
     * @param vals An {@code Array<T>} of values entered into the Dictionary
     */
    public Dictionary(Array<Key> keys, Array<Val> vals) {
        this();
        if (keys.length() > vals.length()) {
            throw new InvalidValueException(
                String.format(
                    Dictionary.InKeyEx,
                    keys.length(),
                    vals.length()
                )
            );
        } else if (vals.length() > keys.length()) {
            throw new InvalidValueException(
                String.format(
                    Dictionary.InValEx,
                    vals.length(),
                    keys.length()
                )
            );
        }
        this.kArr = keys;
        this.vArr = vals;
        this.len = this.kArr.length();
    }
    /**
     * Constructor that takes a general array of keys of and values
     * @param keys general array of keys
     * @param vals general array of values
     */
    public Dictionary(Key[] keys, Val[] vals) {
        this(new Array<Key>(keys), new Array<Val>(vals));
    }
    /**
     * Adding a single key and value to the array
     * @param key they key to be added
     * @param val the value that will be mapped to that key
     */
    public void append(Key key, Val val) {
        for (Key k: this.kArr) {
            if (key.equals(k)) {
                throw new DuplicateKeyException(
                    String.format(
                        Dictionary.DupKeyE, 
                        key
                    )
                );
            }
        }
        this.kArr.append(key);
        this.vArr.append(val);
        this.len = this.kArr.length();
    }
    /**
     * Appending an array of keys and an array of values to the Dictionary
     * @param keys An array of keys to add to the dictionary
     * @param vals An array of values that will map to the array of keys. 
     * Each key index will be mapped to the value of the same index
     */
    public void append(Key[] keys, Val[] vals) {
        if (keys.length > vals.length) {
            throw new InvalidValueException(
                String.format(
                    InKeyEx, 
                    keys.length,
                    vals.length
                )
            );
        }
        if (vals.length > keys.length) {
            throw new InvalidValueException(
                String.format(
                    InValEx, 
                    vals.length,
                    keys.length
                )
            );
        }
        for (Key newKey: keys) {
            for (Key oldKey: this.kArr) {
                if (newKey.equals(oldKey)) {
                    throw new DuplicateKeyException(
                        String.format(
                            Dictionary.DupKeyE,
                            newKey
                        )
                    );
                }
            }
        }
        this.kArr.append(keys);
        this.vArr.append(vals);
        this.len = this.kArr.length();
    }
    /**
     * Appending an {@code Array<T>} of keys and an array of values to the Dictionary
     * @param keys An array of keys to add to the dictionary
     * @param vals An array of values that will map to the array of keys. 
     * Each key index will be mapped to the value of the same index
     */
    public void append(Array<Key> keys, Array<Val> vals) {
        if (keys.length() > vals.length()) {
            throw new InvalidValueException(
                String.format(
                    InKeyEx, 
                    keys.length(),
                    vals.length()
                )
            );
        }
        if (vals.length() > keys.length()) {
            throw new InvalidValueException(
                String.format(
                    InValEx, 
                    vals.length(),
                    keys.length()
                )
            );
        }
        for (Key oldKey: keys) {
            for (Key newKey: this.kArr) {
                if (oldKey.equals(newKey)) {
                    throw new DuplicateKeyException(
                        String.format(
                            Dictionary.DupKeyE,
                            newKey
                        )
                    ); 
                }
            }
        }
        this.kArr.append(keys);
        this.vArr.append(vals);
    }
    /**
     * remove a specific key and value from the dictionary using the key
     * @param key the key mapped to the specific value
     */
    public void remove(Key key) {
        int index = this.kArr.indexOf(key);
        if (index == -1) {
            throw new KeyNotFoundException(
                String.format(
                    KeyDNEE, 
                    key
                )
            );
        }
        this.kArr.remove(index);
        this.vArr.remove(index);
        this.len = this.kArr.length();
    }
    /**
     * Removing an array of keys and values using an array of keys 
     * @param keys an Array that maps to each of values
     */
    public void remove(Key[] keys) {
        for (Key k: keys) {
            this.remove(k);
        }
    }
    /**
     * Removing an array of keys and values using an {@code Array<Key>}
     * @param keys {@code Array<Keys>} of keys
     */
    public void remove(Array<Key> keys) {
        for (Key k: keys) {
            this.remove(k);
        }
    }
    /**
     * Removes a value and a key from the Dictionary
     * @param key the key mapped to that value
     * @return a new {@code Dictionary<Key, Val>} with just that key and value
     */
    public Dictionary<Key, Val> pop(Key key) {
        if (!this.kArr.contains(key)) {
            throw new KeyNotFoundException(
                String.format(
                    Dictionary.KeyDNEE, 
                    key
                )
            );
        }

        int index = this.kArr.indexOf(key);
        Key k = this.kArr.pop(index);
        Val v = this.vArr.pop(index);
        return new Dictionary<Key, Val>(k, v);
    }
    /**
     * Gets the value mapped to a certain Key
     * @param key The key that maps to the value
     * @return the value mapped to the key
     */
    public Val getValue(Key key) {
        if (!this.kArr.contains(key)) {
            throw new KeyNotFoundException(
                String.format(
                    Dictionary.KeyDNEE,
                    key    
                )
            );
        }
        int index = this.kArr.indexOf(key);
        return this.vArr.valueOf(index);
    }
    /**
     * Returns all keys
     * @return an {@code Array<Key>} of keys
     */
    public Array<Key> getKeys() {
        return this.kArr;
    }
    /**
     * Gets the last key from the dictionary
     * @return a The last key
     */
    public Key getLastItem() {
        return this.kArr.getLastItem();
    }
    /**
     * Changing a specific value mapped to a key
     * @param key the key where the value is stored
     * @param newVal the new value to replace the old one
     */
    public void changeValue(Key key, Val newVal) {
        if (!this.kArr.contains(key)) {
            throw new KeyNotFoundException(
                String.format(
                    Dictionary.KeyDNEE, 
                    key
                )
            );
        }
        int index = this.kArr.indexOf(key);
        this.vArr.edit(index, newVal);
    }
    /**
     * Get a literal view of specific details
     * @param key the key of where the details are
     * @return A {@code String} Literal representaion of the Key and the value
     */
    public String getDetails(Key key) {
        int index = this.kArr.indexOf(key);
        return "Key: " + this.kArr.valueOf(index) + ", Value: " + this.vArr.valueOf(index);
    }
    /**
     * calls the {@code toString()} method of the keys
     * @return the keys toString
     */
    public String keyToString() {
        return this.kArr.toString();
    }
    /**
     * calls the {@code toString()} method of the values
     * @return the values toString
     */
    public String valueToString() {
        return this.vArr.toString();
    }
    //Using super docs
    @Override
    public String toString() {
        String msg = (
            "Class <" + this.getClass() + ">\n" +
            "Length [" + this.len + "]\n" + 
            "Last Key[" + this.kArr.getLastItem() + "]\n" + 
            "Keys {"
        );

        for (Key key: this.kArr) {
            msg += " " + key;
            if (!key.equals(this.kArr.getLastItem())) {
                msg += ",";
            } else {
                msg += " }\n";
            }
        }

        msg += "Items {";
        
        for (Val val: this.vArr) {
            msg += " " + val;
            if (!val.equals(this.vArr.getLastItem())) {
                msg += ",";
            } else {
                msg += "}\n";
            }
        }
        return msg;
    }
    /**
     * The Key Iterator that uses the {@link java.lang.Iterable} and {@link java.util.Iterator}
     */
    public final class KeyIterator implements Iterable<Key>, Iterator<Key> {
        private int lastIndex = Dictionary.this.len - 1;
        private int currentIndex = 0;


        @Override
        public boolean hasNext() {
            return this.currentIndex > this.lastIndex;
        }

        @Override
        public Key next() {
            return Dictionary.this.kArr.valueOf(currentIndex++);
        }

        @Override
        public Iterator<Key> iterator() {
            return new Array<Key>(kArr);
        }
    }
    /**
     * The Value Iterator that uses the {@link java.lang.Iterable} and {@link java.util.Iterator}
     */
    public final class ValueIterator implements Iterable<Val>, Iterator<Val> {
        private int lastIndex = Dictionary.this.len - 1;
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return this.currentIndex > this.lastIndex;
        }

        @Override
        public Val next() {
            return Dictionary.this.vArr.valueOf(currentIndex++);
        }

        @Override
        public Iterator<Val> iterator() {
            return new Array<Val>(vArr);
        }
    }
}