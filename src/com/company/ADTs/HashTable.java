package com.company.ADTs;

public class HashTable<Key, Value> {
    public class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K key() {
            return this.key;
        }
        public V value() {
            return this.value;
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
        Entry entry = new Entry(key, value);
        values[hash(key)] = entry;
    }

    public Value get(Key key) {
        return (Value) values[hash(key)].value();
    }

}
