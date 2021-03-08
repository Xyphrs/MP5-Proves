package ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HashTableTest2 {

    @ParameterizedTest
    @CsvSource({"5,5", "10,10", "30,30"})
    void put(String key, String value) {
        ex1.HashTable hashTable = new ex1.HashTable();
        hashTable.put(key, value);
        Assertions.assertNotNull(hashTable.get(key));
    }

    @ParameterizedTest
    @CsvSource({"5", "10", "20"})
    void get(String key) {
        ex1.HashTable hashTable = new ex1.HashTable();
        for(int i=0; i<30; i++) {
            final String keys = String.valueOf(i);
            hashTable.put(keys, keys);
        }
        Assertions.assertEquals(key, hashTable.get(key));
    }

    @ParameterizedTest
    @CsvSource({"5", "10", "20"})
    void drop(String key) {
        ex1.HashTable hashTable = new ex1.HashTable();
        hashTable.put(key,key);
        hashTable.drop(key);
        Assertions.assertEquals(0, hashTable.count());
        Assertions.assertNull(hashTable.get(key));
    }

    @org.junit.jupiter.api.Test
    void count() {
        ex1.HashTable hashTable = new ex1.HashTable();
        hashTable.put("5","5");
        Assertions.assertEquals(1, hashTable.count());
        hashTable.drop("5");
        Assertions.assertEquals(0, hashTable.count());
    }

    @org.junit.jupiter.api.Test
    void size() {
        ex1.HashTable hashTable = new HashTable();
        Assertions.assertEquals(16, hashTable.size());
    }
}