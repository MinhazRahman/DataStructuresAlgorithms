package hashing;

import java.util.Arrays;

/**
 * Hashing is designed to solve the problem of needing to efficiently find or store an item in a collection.
 * Hashing means using some function or algorithm to map object data to some representative integer value.
 * This so-called hash code (or simply hash) can then be used as a way to narrow down our search when looking for the item in the map.
 *
 * Generally, these hash codes are used to generate an index, at which the value is stored.
 *      hashCode = hash(key);
 *      index = hashCode % array_size;
 *
 * Hash tables have to support 3 functions.
 *      insert (key, value)
 *      get (key)
 *      delete (key)
 * */

class MyHashTable {
    Node[] hashTable;

    public MyHashTable(int size){
        hashTable = new Node[size];
        Arrays.fill(hashTable, null);
    }

    public int hash(int key){
        return key + 31;
    }

    public void insert(int key, Node node){
        int hashCode = hash(key);
        int index = hashCode % hashTable.length;
        hashTable[index] = node;
    }

    public Node get(int key){
        int hashCode = hash(key);
        int index = hashCode % hashTable.length;
        Node node = hashTable[index];
        return node;
    }
}
