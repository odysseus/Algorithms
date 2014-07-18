package com.company.ADTs;

import java.util.Map;

public class HashTable<Key, Value> {
    public class Entry implements Map.Entry<Key,Value> {
        private Key key;
        private Value value;

        public Entry(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
        public Key getKey() {
            return this.key;
        }
        public Value getValue() {
            return this.value;
        }
        public void setKey(Key key) {
            this.key = key;
        }
        public Value setValue(Value value) {
            this.value = value;
            return value;
        }
    }

    private LinkedList<Entry>[] values;
    private int M;

    public HashTable(int size) {
        values = new LinkedList[size];
        M = size;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(Key key, Value value) {
        Entry entry = new Entry(key, value);
        int index = hash(key);
        if (values[index] == null) {
            values[index] = new LinkedList<>();
            values[index].append(entry);
        } else {
            values[index].append(entry);
        }
    }

    public Entry getEntry(Key key) {
        int index = hash(key);
        for (Object o : values[index]) {
            Entry e = (Entry) o;
            if (e.getKey() == key) {
                return e;
            }
        }
        return null;
    }

    public Value get(Key key) {
        try {
            Entry e = getEntry(key);
            return (Value) e.getValue();
        } catch (NullPointerException e) {
            return null;
        }
    }

}
