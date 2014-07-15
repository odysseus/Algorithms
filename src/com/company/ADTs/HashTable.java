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

    private Entry[] values;
    private int M;

    public HashTable(int size) {
        values = new Entry[size];
        M = size;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(Key key, Value value) {
        Entry entry = new Entry<>(key, value);
        values[hash(key)] = entry;
    }

    public Entry getEntry(Key key) {
        return values[hash(key)];
    }

    public Value get(Key key) {
       Entry e = getEntry(key);
       return (Value) e.getValue();
    }

}
