package src.test.java_basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.java_basics.ConcurrentModification;

import java.util.ConcurrentModificationException;

public class BasicTests {
    @Test
    void testConcurrentModification(){
        Assertions.assertThrows(ConcurrentModificationException.class, ConcurrentModification::failFast);
        Assertions.assertDoesNotThrow(ConcurrentModification::failSafe);
    }
}
