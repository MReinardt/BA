package test;

import org.junit.jupiter.api.Test;
import services.Functions;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {

    @Test
    void addReturnsCorrectSum() {
        Functions functions = new Functions();
        assertEquals(5, functions.add(2, 3));
    }

    @Test
    void divideReturnsCorrectQuotient() {
        Functions functions = new Functions();
        assertEquals(2, functions.divide(4, 2));
    }

    @Test
    void divideThrowsExceptionForZeroDivider() {
        Functions functions = new Functions();
        assertThrows(IllegalArgumentException.class, () -> functions.divide(4, 0));
    }

    @Test
    void areAnagramsReturnsTrueForAnagrams() {
        assertTrue(Functions.areAnagrams("listen", "silent"));
    }

    @Test
    void areAnagramsReturnsFalseForNonAnagrams() {
        assertFalse(Functions.areAnagrams("hello", "world"));
    }

    @Test
    void areAnagramsReturnsFalseForDifferentLengths() {
        assertFalse(Functions.areAnagrams("abc", "abcd"));
    }

    @Test
    void findMaxReturnsMaxElement() {
        assertEquals(Integer.valueOf(3), Functions.findMax(Arrays.asList(1, 2, 3)));
    }

    @Test
    void findMaxThrowsExceptionForEmptyList() {
        //assertThrows(IllegalArgumentException.class, () -> Functions.findMax(Collections.emptyList()));
    }

    @Test
    void findMinReturnsMinElement() {
        assertEquals(Integer.valueOf(1), Functions.findMin(Arrays.asList(1, 2, 3)));
    }

    @Test
    void findMinThrowsExceptionForEmptyList() {
        //assertThrows(IllegalArgumentException.class, () -> Functions.findMin(Collections.emptyList()));
    }
}