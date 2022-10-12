package hashing;

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

public class MainHash {

    public static void main(String[] args) {
        // create a hash table
        MyHashTable hashTable = new MyHashTable(10);

        // insert the data into the hash table
        hashTable.insert(1, new Node(10));
        hashTable.insert(4, new Node(40));
        hashTable.insert(14, new Node(44)); // collision happens for keys 4 and 14
        hashTable.insert(3, new Node(30));
        hashTable.insert(5, new Node(50));
        hashTable.insert(6, new Node(60));

        // retrieve the node
        System.out.println(hashTable.get(4));
        System.out.println(hashTable.get(5));
        System.out.println(hashTable.get(6));
        System.out.println(hashTable.get(7));

    }
}
