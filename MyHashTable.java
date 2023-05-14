import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private List<List<Entry<K, V>>> buckets;
    private int size;
    private int capacity;
    private double loadFactor;

    public MyHashTable() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashTable(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashTable(int capacity, double loadFactor) {
        this.buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            this.buckets.add(new LinkedList<>());
        }
        this.size = 0;
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int bucketIndex = getBucketIndex(key);
        List<Entry<K, V>> bucket = this.buckets.get(bucketIndex);
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        this.size++;
        if ((double) this.size / this.capacity >= this.loadFactor) {
            rehash();
        }
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int bucketIndex = getBucketIndex(key);
        List<Entry<K, V>> bucket = this.buckets.get(bucketIndex);
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int bucketIndex = getBucketIndex(key);
        List<Entry<K, V>> bucket = this.buckets.get(bucketIndex);
        for (int i = 0; i < bucket.size(); i++) {
            Entry<K, V> entry = bucket.get(i);
            if (entry.key.equals(key)) {
                bucket.remove(i);
                this.size--;
                return entry.value;
            }
        }
        return null;
    }

    public int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int bucketIndex = hashCode % this.capacity;
        return Math.abs(bucketIndex);
    }

    private void rehash() {
        List<List<Entry<K, V>>> oldBuckets = this.buckets;
        this.capacity *= 2;
        this.size = 0;
        this.buckets = new ArrayList<>(this.capacity);
        for (int i = 0; i < this.capacity; i++) {
            this.buckets.add(new LinkedList<>());
        }
        for (List<Entry<K, V>> bucket : oldBuckets) {
            for (Entry<K, V> entry : bucket) {
                this.put(entry.key, entry.value);
            }
        }
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}