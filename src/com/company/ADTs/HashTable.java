package com.company.ADTs;

import java.util.Map;

public class HashTable<Key, Value> {
    public class Entry<K,V> implements Map.Entry<K,V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return this.key;
        }
        public V getValue() {
            return this.value;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }

    private LinkedList<Entry<Key,Value>>[] values;
    private int M;

    public HashTable(int size) {
        values = new LinkedList[size];
        M = size;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(Key key, Value value) {
        Entry<Key,Value> entry = new Entry<>(key, value);
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
        for (Entry e : values[index]) {
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
