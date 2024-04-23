//Sebastian Xayaphet
//COSC 2336
//Programming Assignment 10
//Due: 11/1/2023
//The code in Chapter 27 implements the MyMap interface using separate chaining. 
//For this assignment, you will implement MyMap using open addressing with linear probing.
//Create a new concrete class namedMyHashMap that implements MyMap using open addressing with linear probing.
//For simplicity, use f(key) = key % size as the hash function, where size is the hash-table size.
//Initially, the hash-table size is 4.The table size is doubled whenever the load factor exceeds the threshold ( 0.5 ).
//Modify TestMyHashMap.java in the text slightly and use it to test MyHashMap.
public class MyHashMap<K, V> implements MyMap<K, V> {
  // Define the default hash table size. Must be a power of 2
  private final static int DEFAULT_INITIAL_CAPACITY = 4;

  // Define the maximum hash table size. 1 << 30 is the same as 2^30
  private final static int MAXIMUM_CAPACITY = 1 << 30;

  // Current hash table capacity. Capacity is a power of 2
  private int capacity;

  // Define default load factor
  private final static float DEFAULT_MAX_LOAD_FACTOR = 0.5f;

  // Specify a load factor used in the hash table
  private float loadFactorThreshold;

  // The number of entries in the map
  private int size = 0;

  // Hash table is an array with each cell that is a key-value pair
  private Entry<K, V>[] table;

  /** Construct a map with the default capacity and load factor */
  public MyHashMap() {
    this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
  }

  /** Construct a map with the specified initial capacity and default load factor */
  public MyHashMap(int initialCapacity) {
    this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
  }

  /** Construct a map with the specified initial capacity and load factor */
  public MyHashMap(int initialCapacity, float loadFactorThreshold) {
    if (initialCapacity > MAXIMUM_CAPACITY)
      this.capacity = MAXIMUM_CAPACITY;
    else
      this.capacity = trimToPowerOf2(initialCapacity);

    this.loadFactorThreshold = loadFactorThreshold;
    table = new Entry[capacity];
  }

  @Override /** Remove all of the entries from this map */
  public void clear() {
    size = 0;
    table = new Entry[capacity]; // Create a new table
  }

  @Override /** Return true if the specified key is in the map */
  public boolean containsKey(K key) {
    int i = hash(key.hashCode());
    while (table[i] != null) {
      if (table[i].key.equals(key)) {
        return true;
      }
      i = (i + 1) % capacity; // Linear probing
    }
    return false;
  }

  @Override /** Return true if this map contains the value */
  public boolean containsValue(V value) {
    for (int i = 0; i < capacity; i++) {
      if (table[i] != null && table[i].value.equals(value)) {
        return true;
      }
    }
    return false;
  }

  @Override /** Return a set of entries in the map */
  public java.util.Set<MyMap.Entry<K, V>> entrySet() {
    java.util.Set<MyMap.Entry<K, V>> set =
      new java.util.HashSet<>();

    for (int i = 0; i < capacity; i++) {
      if (table[i] != null) {
        set.add(table[i]);
      }
    }

    return set;
  }

  @Override /** Return the value that matches the specified key */
  public V get(K key) {
    int i = hash(key.hashCode());
    while (table[i] != null) {
      if (table[i].key.equals(key)) {
        return table[i].value;
      }
      i = (i + 1) % capacity; // Linear probing
    }
    return null;
  }

  @Override /** Return true if this map contains no entries */
  public boolean isEmpty() {
    return size == 0;
  }

  @Override /** Return a set consisting of the keys in this map */
  public java.util.Set<K> keySet() {
    java.util.Set<K> set = new java.util.HashSet<>();

    for (int i = 0; i < capacity; i++) {
      if (table[i] != null) {
        set.add(table[i].key);
      }
    }

    return set;
  }

  @Override /** Add an entry (key, value) into the map */
  public V put(K key, V value) {
    if (size >= capacity * loadFactorThreshold) {
      if (capacity == MAXIMUM_CAPACITY)
        throw new RuntimeException("Exceeding maximum capacity");

      rehash();
    }

    int i = hash(key.hashCode());
    while (table[i] != null) {
      if (table[i].key.equals(key)) {
        V oldValue = table[i].value;
        table[i].value = value;
        return oldValue;
      }
      i = (i + 1) % capacity; // Linear probing
    }

    table[i] = new Entry<>(key, value);
    size++; // Increase size

    return value;
  }

  @Override /** Remove the entries for the specified key */
  public void remove(K key) {
    int i = hash(key.hashCode());
    while (table[i] != null) {
      if (table[i].key.equals(key)) {
        // Delete the entry
        table[i] = null;
        size--; // Decrease size
        // Reorganize the hash table
        i = (i + 1) % capacity; // Linear probing
        while (table[i] != null) {
          K newKey = table[i].key;
          V newValue = table[i].value;
          table[i] = null;
          size--; // Decrease size
          put(newKey, newValue); // Reinsert the element
          i = (i + 1) % capacity; // Linear probing
        }
        return; // Exit
      }
      i = (i + 1) % capacity; // Linear probing
    }
  }

  @Override /** Return the number of entries in this map */
  public int size() {
    return size;
  }

  @Override /** Return a set consisting of the values in this map */
  public java.util.Set<V> values() {
    java.util.Set<V> set = new java.util.HashSet<>();

    for (int i = 0; i < capacity; i++) {
      if (table[i] != null) {
        set.add(table[i].value);
      }
    }

    return set;
  }

  /** Hash function */
  private int hash(int hashCode) {
    return Math.abs(hashCode) % capacity;
  }

  /** Return a power of 2 for initialCapacity */
  private int trimToPowerOf2(int initialCapacity) {
    int capacity = 1;
    while (capacity < initialCapacity) {
      capacity <<= 1;
    }

    return capacity;
  }

  /** Rehash the map */
  private void rehash() {
    java.util.Set<Entry<K, V>> set = entrySet(); // Get entries
    capacity <<= 1; // Double capacity
    table = new Entry[capacity]; // Create a new hash table
    size = 0; // Reset size to 0

    for (Entry<K, V> entry : set) {
      put(entry.key, entry.value); // Store to the new table
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("[");

    for (int i = 0; i < capacity; i++) {
      if (table[i] != null) {
        builder.append(table[i]);
      }
    }

    builder.append("]");
    return builder.toString();
  }
}
