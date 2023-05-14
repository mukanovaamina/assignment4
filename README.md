# assignment4
#Mukanova Amina, SE-2215


"MyTestingClass(int id, String name)": This is the constructor of the class which takes in two,
id and name, and initializes the id and name instance variables with the given values.


"public int hashCode()": This method overrides the default hashCode() method provided
by Java and returns a custom hash code for the instance of the class. 
The hash code is calculated using the id and name instance variables.


"public int getId()": This method returns the value of the id instance variable.


"public void setId(int id)": This method sets the value of the id instance variable to the given id.


"public String getName()": This method returns the value of the name instance variable.


"public void setName(String name)": This method sets the value of the name instance variable to the given name.


"public MyHashTable()": Constructor for creating a new MyHashTable object with default
capacity and load factor


"public MyHashTable(int capacity)": Constructor for creating a new MyHashTable object with 
the specified capacity and default load factor


"public MyHashTable(int capacity, double loadFactor)": Constructor for creating a new MyHashTable
object with the specified capacity and load factor


"public int size()": Returns the number of key-value pairs in the hash table


"public boolean isEmpty()": Returns true if the hash table is empty, false otherwise


"public void put(K key, V value)": Puts a key-value pair into the hash table


"public V get(K key)": Returns the value associated with the given key in the hash table,
or null if the key is not found


"public V remove(K key)": Removes the key-value pair associated with the given key 
from the hash table and returns its value, or null if the key is not found


"public int getBucketIndex(K key)": Returns the index of the bucket where the key should be
located in the hash table


"private void rehash()": Increases the capacity of the hash table, rehashes all the elements,
and updates the size and capacity accordingly


"private static class Entry<K, V>": Represents a key-value pair that can be stored in the hash table. 
The Entry class is only used internally by the MyHashTable class.