package test;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import services.Functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestManuelFunctions {

    @Test
    @DisplayName("Test Complex_Methods >> areAnagrams method")
    public void test_ComplexMethodsAreAnagrams() {
        //Anagramme
        assertTrue(Functions.areAnagrams("Leben", "Nebel"));
        assertTrue(Functions.areAnagrams("Palme", "Lampe"));
        assertTrue(Functions.areAnagrams("Mehl", "Helm"));
        assertTrue(Functions.areAnagrams("TEST_2", "Test_2"));

        //keine Anagramme
        assertFalse(Functions.areAnagrams("Hello", "World"));
        assertFalse(Functions.areAnagrams("Test_1", "Test_2"));

        //Grenzwerte
        assertFalse(Functions.areAnagrams("", "World"));
        assertFalse(Functions.areAnagrams("Hello", ""));
        assertFalse(Functions.areAnagrams("", "Hello"));
        assertFalse(Functions.areAnagrams("", ""));
        assertFalse(Functions.areAnagrams(null, null));
    }

    @Test
    @DisplayName("Test Generic_Methods >> findMax method with Integer")
    public void test_GenericFunctionsWithInteger() {
        List<Integer> values = Arrays.asList(1, 2250, 30000, 230);

        assertEquals(30000, Functions.findMax(values));
    }

    @Test
    @DisplayName("Test Generic_Methods >> findMax method with String")
    public void test_GenericFunctionsWithString() {
        List<String> values = Arrays.asList("Hello", "World", "Max", "Mustermann");

        assertEquals("World", Functions.findMax(values));
    }

    @Test
    @DisplayName("Test Generic_Methods >> findMax method with empty list")
    public void test_GenericFunctionsExceptionHandlingWithEmptyList() {
        List<String> values = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> Functions.findMax(values));
    }

    @Test
    @DisplayName("Test Generic_Methods >> findMax method with null")
    public void test_GenericFunctionsExceptionHandlingWithNull() {
        assertThrows(IllegalArgumentException.class, () -> Functions.findMax(null));
    }
}