package src.test.cache_implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.cache_implementations.LRU;

public class LRUTest {

    @Test
    void testLRU(){
        LRU cache = new LRU(4);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.put(5,5);
        Assertions.assertEquals(4, cache.getSize());
        cache.printContent();

        cache.get(2);
        cache.get(3);
        cache.put(6,6);
        Assertions.assertEquals(-1, cache.get(4));
        cache.printContent();
    }
}
