package ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HashTableTest {

    @ParameterizedTest
    @CsvSource({"5,5", "10,10", "30,30"})
    void put(String key, String value) {
        Assertions.assertEquals(key,value);
    }

    @ParameterizedTest
    @CsvSource({"5", "10", "20"})
    void get(String key) {
        HashTable hashTable = new HashTable();
        for(int i=0; i<30; i++) {
            final String keys = String.valueOf(i);
            hashTable.put(keys, keys);
        }
        Assertions.assertEquals(key, hashTable.get(key));
    }

    @ParameterizedTest
    @CsvSource({"5", "10", "20"})
    void drop(String key) {
        HashTable hashTable = new HashTable();
        for(int i=0; i<30; i++) {
            final String keys = String.valueOf(i);
            hashTable.put(keys, keys);
        }
        hashTable.drop(key);
        Assertions.assertNull(hashTable.get(key));
    }

    @org.junit.jupiter.api.Test
    void count() {
        HashTable hashTable = new HashTable();
        Assertions.assertEquals(0, hashTable.count());
    }

    @org.junit.jupiter.api.Test
    void size() {
        HashTable hashTable = new HashTable();
        Assertions.assertEquals(16, hashTable.size());
    }
}