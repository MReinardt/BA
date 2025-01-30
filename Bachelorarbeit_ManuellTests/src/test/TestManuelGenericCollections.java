package test;

import generic.BoundedStack;
import generic.GenericStack;
import generic.MultiMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestManuelGenericCollections {

    //region BoundedStack

    @Test
    @DisplayName("Test BoundedStack >> with Integer clear() method")
    void test_BoundedStack_Clear() {
        BoundedStack<Integer> intStack = new BoundedStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        assertEquals(3, intStack.size());
        intStack.clear();
        assertTrue(intStack.isEmpty());
    }

    @Test
    @DisplayName("Test BoundedStack >> with Integer ExceptionHandling of peek() method")
    void test_BoundedStack_ExceptionHandling_Peek() {
        assertThrows(EmptyStackException.class, () -> (new BoundedStack<Integer>()).peek());
    }

    @Test
    @DisplayName("Test BoundedStack >> with Float ExceptionHandling of pop() method")
    void test_BoundedStack_ExceptionHandling_Pop() {
        assertThrows(EmptyStackException.class, () -> (new BoundedStack<Float>()).pop());
    }
    @Test
    @DisplayName("Test BoundedStack >> with Integer use case")
    void test_BoundedStackWithInteger() {

        BoundedStack<Integer> intStack = new BoundedStack<>();
        assertTrue(intStack.isEmpty());

        intStack.push(100);
        intStack.push(200);
        intStack.push(300);

        assertEquals(300, intStack.peek());
        assertEquals(3, intStack.size());

        assertEquals(300, intStack.pop());
        assertEquals(2, intStack.size());
        assertEquals(200, intStack.peek());
    }

    @Test
    @DisplayName("Test BoundedStack >> with Float use case")
    void test_BoundedStackWithFloat() {

        BoundedStack<Float> intStack = new BoundedStack<>();
        assertTrue(intStack.isEmpty());

        intStack.push(1.0f);
        intStack.push(2.0f);
        intStack.push(3.0f);

        assertEquals(3.0f, intStack.peek());
        assertEquals(3, intStack.size());

        assertEquals(3.0f, intStack.pop());
        assertEquals(2, intStack.size());
        assertEquals(2.0f, intStack.peek());
    }

    //endregion

    //region GenericStack

    @Test
    @DisplayName("Test GenericStack >> with Integer clear() method")
    void test_GenericStack_Clear() {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        assertEquals(3, intStack.size());
        intStack.clear();
        assertTrue(intStack.isEmpty());
    }

    @Test
    @DisplayName("Test GenericStack >> with Integer ExceptionHandling of peek() method")
    void test_GenericStack_ExceptionHandling_Peek() {
        assertThrows(EmptyStackException.class, () -> (new GenericStack<Integer>()).peek());
    }

    @Test
    @DisplayName("Test GenericStack >> with Integer ExceptionHandling of pop() method")
    void test_GenericStack_ExceptionHandling_Pop() {
        assertThrows(EmptyStackException.class, () -> (new GenericStack<Integer>()).pop());
    }

    @Test
    @DisplayName("Test GenericStack >> with Integer use case")
    void test_GenericStackWithInteger() {

        GenericStack<Integer> intStack = new GenericStack<>();
        assertTrue(intStack.isEmpty());

        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        assertEquals(30, intStack.peek());
        assertEquals(3, intStack.size());

        assertEquals(30, intStack.pop());
        assertEquals(2, intStack.size());
        assertEquals(20, intStack.peek());
    }

    @Test
    @DisplayName("Test GenericStack >> with string use case")
    void test_GenericStackWithString() {

        GenericStack<String> stringStack = new GenericStack<>();
        assertTrue(stringStack.isEmpty());

        stringStack.push("Test_0");
        stringStack.push("Test_1");
        stringStack.push("Test_2");
        stringStack.push("Test_3");

        assertEquals("Test_3", stringStack.peek());
        assertEquals(4, stringStack.size());

        assertEquals("Test_3", stringStack.pop());
        assertEquals("Test_2", stringStack.pop());
        assertEquals(2, stringStack.size());

        stringStack.clear();
        assertEquals(0, stringStack.size());
    }

    //endregion

    //region MultiMap

    @Test
    @DisplayName("Test MultiMap >> with null key and value")
    void test_MultiMapWithNullableKeyAndValue() {
        MultiMap<String, List<Integer>> multiMap = new MultiMap<>();

        List<Integer> values = Arrays.asList(1, 2, 3);
        multiMap.put(null, values);
        assertEquals(values, multiMap.get(null));

        multiMap.put("Key1", null);
        assertNull(multiMap.get("Key1"));
    }

    @Test
    @DisplayName("Test MultiMap >> with Integer")
    void test_MultiMapWithInteger() {
        MultiMap<String, List<Integer>> multiMap = new MultiMap<>();
        List<Integer> values = Arrays.asList(10, 20, 30);
        multiMap.put("Key1", values);

        assertEquals(values, multiMap.get("Key1"));
    }

    @Test
    @DisplayName("Test MultiMap >> with Double")
    void test_MultiMapWithDouble() {
        MultiMap<String, List<Double>> multiMap = new MultiMap<>();
        List<Double> values = Arrays.asList(10.0, 20.0, 30.0);
        multiMap.put("Key1", values);

        assertEquals(values, multiMap.get("Key1"));
    }

    @Test
    @DisplayName("Test MultiMap >> with Float")
    void test_MultiMapWithFloat() {
        MultiMap<String, List<Float>> multiMap = new MultiMap<>();
        List<Float> values = Arrays.asList(10.0f, 20.0f, 30.0f);
        multiMap.put("Key1", values);

        assertEquals(values, multiMap.get("Key1"));
    }

    //endregion
}
