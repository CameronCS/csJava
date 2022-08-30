package csjav;

import csjav.DictExcept.InvalidValueException;
import csjav.DictExcept.KeyNotFoundException;
import csjav.DictExcept.DuplicateKeyException;

import java.util.Iterator;

public class Dictionary<Key, Val> {
    private Array<Key> kArr;
    private Array<Val> vArr;
    private int len;

    private final String InKeyEx = "Key length <%d> can not be greater than Value length<%d>";
    private final String InValEx = "Value length <%d> can not be greater than Key length<%d>";
    private final String DupKeyE = "Key <%s> already exists";
    private final String KeyDNEE = "Key <%s> already Exists";

    public KeyIter Keys;
    public ValueIter Values;

    public Dictionary() {
        this.kArr = new Array<>();
        this.vArr = new Array<>();
        this.len = 0;
        this.Keys = new KeyIter();
        this.Values = new ValueIter();
    }

    public Dictionary(Key key, Val val) {
        this();
        this.kArr.append(key);
        this.vArr.append(val);
        this.len = this.kArr.length();
    }

    public Dictionary(Array<Key> keys, Array<Val> vals) {
        this();
        if (keys.length() > vals.length()) {
            throw new InvalidValueException(
                String.format(
                    this.InKeyEx,
                    keys.length(),
                    vals.length()
                )
            );
        } else if (vals.length() > keys.length()) {
            throw new InvalidValueException(
                String.format(
                    this.InValEx,
                    vals.length(),
                    keys.length()
                )
            );
        }
        this.kArr = keys;
        this.vArr = vals;
        this.len = this.kArr.length();
    }

    public Dictionary(Key[] keys, Val[] vals) {
        this(new Array<Key>(keys), new Array<Val>(vals));
    }

    public void append(Key key, Val val) {
        for (Key k: this.kArr) {
            if (key.equals(k)) {
                throw new DuplicateKeyException(
                    String.format(
                        this.DupKeyE, 
                        key
                    )
                );
            }
        }
        this.kArr.append(key);
        this.vArr.append(val);
        this.len = this.kArr.length();
    }

    public void append(Key[] keys, Val[] vals) {
        for (Key newKey: keys) {
            for (Key oldKey: this.kArr) {
                if (newKey.equals(oldKey)) {
                    throw new DuplicateKeyException(
                        String.format(
                            this.DupKeyE,
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

    public void append(Array<Key> keys, Array<Val> vals) {
        for (Key oldKey: keys) {
            for (Key newKey: this.kArr) {
                if (oldKey.equals(newKey)) {
                    throw new DuplicateKeyException(
                        String.format(
                            this.DupKeyE,
                            newKey
                        )
                    );
                }
            }
        }

        this.kArr.append(keys);
        this.vArr.append(vals);
    }

    public void remove(Key key) {
        int index = this.kArr.indexOf(key);
        this.kArr.remove(index);
        this.vArr.remove(index);
        this.len = this.kArr.length();
    }

    public void remove(Key[] keys) {
        Array<Key> tK = new Array<>();
        Array<Val> tV = new Array<>();
        for (int i = 0; i < this.len; i++) {
            if (this.kArr.valueOf(i) == keys[i]) {
                tK.append(this.kArr.valueOf(i));
                tV.append(this.vArr.valueOf(i));
            }
        }
        for (Key key: tK) {
            this.kArr.remove(key);
        }
        for (Val val: tV) {
            this.vArr.remove(val);
        }
        this.len = this.kArr.length();
    }

    public Val pop(Key key) {
        if (!this.kArr.contains(key)) {
            throw new KeyNotFoundException(
                String.format(
                    this.KeyDNEE, 
                    key
                )
            );
        }

        int index = this.kArr.indexOf(key);
        Val val = vArr.valueOf(index);
        this.kArr.remove(index);
        this.vArr.remove(index);
        return val;
    }

    public Val getValue(Key key) {
        if (!this.kArr.contains(key)) {
            throw new KeyNotFoundException(
                String.format(
                    this.KeyDNEE,
                    key    
                )
            );
        }
        int index = this.kArr.indexOf(key);
        return this.vArr.valueOf(index);
    }

    public Array<Key> getKeys() {
        return this.kArr;
    }

    public Key getLastKey() {
        return this.kArr.getLastItem();
    }

    public Val getLastItem() {
        return this.vArr.getLastItem();
    }

    public void changeValue(Key key, Val val) {
        if (!this.kArr.contains(key)) {
            throw new KeyNotFoundException(
                String.format(
                    this.KeyDNEE, 
                    key
                )
            );
        }
        int index = this.kArr.indexOf(key);
        this.vArr.edit(index, val);
    }

    public String getDetails(Key key) {
        int index = this.kArr.indexOf(key);
        return "Key: " + this.kArr.valueOf(index) + ", Value: " + this.vArr.valueOf(index);
    }

    public String keyToString() {
        return this.kArr.toString();
    }

    public String valueToString() {
        return this.vArr.toString();
    }

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

    public final class KeyIter implements Iterable<Key>, Iterator<Key> {
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

    public final class ValueIter implements Iterable<Val>, Iterator<Val> {
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