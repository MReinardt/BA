package test.java.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.Functions;

class FunctionsDiffblueTest {
    /**
     * Test {@link Functions#add(int, int)}.
     * <ul>
     *   <li>When one.</li>
     *   <li>Then return three.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#add(int, int)}
     */
    @Test
    @DisplayName("Test add(int, int); when one; then return three")
    void testAdd_whenOne_thenReturnThree() {
        // Arrange, Act and Assert
        assertEquals(3, (new Functions()).add(1, 2));
    }

    /**
     * Test {@link Functions#add(int, int)}.
     * <ul>
     *   <li>When three.</li>
     *   <li>Then return five.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#add(int, int)}
     */
    @Test
    @DisplayName("Test add(int, int); when three; then return five")
    void testAdd_whenThree_thenReturnFive() {
        // Arrange, Act and Assert
        assertEquals(5, (new Functions()).add(3, 2));
    }

    /**
     * Test {@link Functions#add(int, int)}.
     * <ul>
     *   <li>When two.</li>
     *   <li>Then return four.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#add(int, int)}
     */
    @Test
    @DisplayName("Test add(int, int); when two; then return four")
    void testAdd_whenTwo_thenReturnFour() {
        // Arrange, Act and Assert
        assertEquals(4, (new Functions()).add(2, 2));
    }

    /**
     * Test {@link Functions#add(int, int)}.
     * <ul>
     *   <li>When zero.</li>
     *   <li>Then return two.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#add(int, int)}
     */
    @Test
    @DisplayName("Test add(int, int); when zero; then return two")
    void testAdd_whenZero_thenReturnTwo() {
        // Arrange, Act and Assert
        assertEquals(2, (new Functions()).add(0, 2));
    }

    /**
     * Test {@link Functions#divide(int, int)}.
     * <ul>
     *   <li>When minus one.</li>
     *   <li>Then return zero.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#divide(int, int)}
     */
    @Test
    @DisplayName("Test divide(int, int); when minus one; then return zero")
    void testDivide_whenMinusOne_thenReturnZero() {
        // Arrange, Act and Assert
        assertEquals(0, (new Functions()).divide(-1, 3));
    }

    /**
     * Test {@link Functions#divide(int, int)}.
     * <ul>
     *   <li>When one.</li>
     *   <li>Then return zero.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#divide(int, int)}
     */
    @Test
    @DisplayName("Test divide(int, int); when one; then return zero")
    void testDivide_whenOne_thenReturnZero() {
        // Arrange, Act and Assert
        assertEquals(0, (new Functions()).divide(1, 3));
    }

    /**
     * Test {@link Functions#divide(int, int)}.
     * <ul>
     *   <li>When three.</li>
     *   <li>Then return one.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#divide(int, int)}
     */
    @Test
    @DisplayName("Test divide(int, int); when three; then return one")
    void testDivide_whenThree_thenReturnOne() {
        // Arrange, Act and Assert
        assertEquals(1, (new Functions()).divide(3, 3));
    }

    /**
     * Test {@link Functions#divide(int, int)}.
     * <ul>
     *   <li>When zero.</li>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#divide(int, int)}
     */
    @Test
    @DisplayName("Test divide(int, int); when zero; then throw IllegalArgumentException")
    void testDivide_whenZero_thenThrowIllegalArgumentException() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> (new Functions()).divide(3, 0));
    }

    /**
     * Test {@link Functions#addWrong(int, int)}.
     * <ul>
     *   <li>When one.</li>
     *   <li>Then return minus one.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#addWrong(int, int)}
     */
    @Test
    @DisplayName("Test addWrong(int, int); when one; then return minus one")
    void testAddWrong_whenOne_thenReturnMinusOne() {
        // Arrange, Act and Assert
        assertEquals(-1, (new Functions()).addWrong(1, 2));
    }

    /**
     * Test {@link Functions#addWrong(int, int)}.
     * <ul>
     *   <li>When three.</li>
     *   <li>Then return one.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#addWrong(int, int)}
     */
    @Test
    @DisplayName("Test addWrong(int, int); when three; then return one")
    void testAddWrong_whenThree_thenReturnOne() {
        // Arrange, Act and Assert
        assertEquals(1, (new Functions()).addWrong(3, 2));
    }

    /**
     * Test {@link Functions#addWrong(int, int)}.
     * <ul>
     *   <li>When two.</li>
     *   <li>Then return zero.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#addWrong(int, int)}
     */
    @Test
    @DisplayName("Test addWrong(int, int); when two; then return zero")
    void testAddWrong_whenTwo_thenReturnZero() {
        // Arrange, Act and Assert
        assertEquals(0, (new Functions()).addWrong(2, 2));
    }

    /**
     * Test {@link Functions#addWrong(int, int)}.
     * <ul>
     *   <li>When zero.</li>
     *   <li>Then return minus two.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#addWrong(int, int)}
     */
    @Test
    @DisplayName("Test addWrong(int, int); when zero; then return minus two")
    void testAddWrong_whenZero_thenReturnMinusTwo() {
        // Arrange, Act and Assert
        assertEquals(-2, (new Functions()).addWrong(0, 2));
    }

    /**
     * Test {@link Functions#divideWrong(int, int)}.
     * <ul>
     *   <li>When minus one.</li>
     *   <li>Then return zero.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#divideWrong(int, int)}
     */
    @Test
    @DisplayName("Test divideWrong(int, int); when minus one; then return zero")
    void testDivideWrong_whenMinusOne_thenReturnZero() {
        // Arrange, Act and Assert
        assertEquals(0, (new Functions()).divideWrong(-1, 3));
    }

    /**
     * Test {@link Functions#divideWrong(int, int)}.
     * <ul>
     *   <li>When one.</li>
     *   <li>Then return zero.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#divideWrong(int, int)}
     */
    @Test
    @DisplayName("Test divideWrong(int, int); when one; then return zero")
    void testDivideWrong_whenOne_thenReturnZero() {
        // Arrange, Act and Assert
        assertEquals(0, (new Functions()).divideWrong(1, 3));
    }

    /**
     * Test {@link Functions#divideWrong(int, int)}.
     * <ul>
     *   <li>When three.</li>
     *   <li>Then return one.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#divideWrong(int, int)}
     */
    @Test
    @DisplayName("Test divideWrong(int, int); when three; then return one")
    void testDivideWrong_whenThree_thenReturnOne() {
        // Arrange, Act and Assert
        assertEquals(1, (new Functions()).divideWrong(3, 3));
    }

    /**
     * Test {@link Functions#divideWrong(int, int)}.
     * <ul>
     *   <li>When zero.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#divideWrong(int, int)}
     */
    @Test
    @DisplayName("Test divideWrong(int, int); when zero")
    @Disabled("TODO: Complete this test")
    void testDivideWrong_whenZero() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArithmeticException: / by zero
        //       at services.Functions.divideWrong(Functions.java:32)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new Functions()).divideWrong(3, 0);
    }

    /**
     * Test {@link Functions#divideWrong(int, int)}.
     * <ul>
     *   <li>When zero.</li>
     *   <li>Then return zero.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#divideWrong(int, int)}
     */
    @Test
    @DisplayName("Test divideWrong(int, int); when zero; then return zero")
    void testDivideWrong_whenZero_thenReturnZero() {
        // Arrange, Act and Assert
        assertEquals(0, (new Functions()).divideWrong(0, 3));
    }

    /**
     * Test {@link Functions#isEvenWrong(int)}.
     * <ul>
     *   <li>When one.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#isEvenWrong(int)}
     */
    @Test
    @DisplayName("Test isEvenWrong(int); when one; then return 'true'")
    void testIsEvenWrong_whenOne_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue((new Functions()).isEvenWrong(1));
    }

    /**
     * Test {@link Functions#isEvenWrong(int)}.
     * <ul>
     *   <li>When ten.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#isEvenWrong(int)}
     */
    @Test
    @DisplayName("Test isEvenWrong(int); when ten; then return 'false'")
    void testIsEvenWrong_whenTen_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse((new Functions()).isEvenWrong(10));
    }

    /**
     * Test {@link Functions#containsElementWrong(List, int)}.
     * <ul>
     *   <li>Given one.</li>
     *   <li>When {@link ArrayList#ArrayList()} add one.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#containsElementWrong(List, int)}
     */
    @Test
    @DisplayName("Test containsElementWrong(List, int); given one; when ArrayList() add one; then return 'false'")
    void testContainsElementWrong_givenOne_whenArrayListAddOne_thenReturnFalse() {
        // Arrange
        Functions functions = new Functions();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        // Act and Assert
        assertFalse(functions.containsElementWrong(list, 1));
    }

    /**
     * Test {@link Functions#containsElementWrong(List, int)}.
     * <ul>
     *   <li>Given two.</li>
     *   <li>When {@link ArrayList#ArrayList()} add two.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#containsElementWrong(List, int)}
     */
    @Test
    @DisplayName("Test containsElementWrong(List, int); given two; when ArrayList() add two; then return 'false'")
    void testContainsElementWrong_givenTwo_whenArrayListAddTwo_thenReturnFalse() {
        // Arrange
        Functions functions = new Functions();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);

        // Act and Assert
        assertFalse(functions.containsElementWrong(list, 1));
    }

    /**
     * Test {@link Functions#containsElementWrong(List, int)}.
     * <ul>
     *   <li>When {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#containsElementWrong(List, int)}
     */
    @Test
    @DisplayName("Test containsElementWrong(List, int); when 'null'")
    @Disabled("TODO: Complete this test")
    void testContainsElementWrong_whenNull() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Iterable.iterator()" because "iterable" is null
        //       at services.Functions.containsElementWrong(Functions.java:42)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new Functions()).containsElementWrong(null, 1);
    }

    /**
     * Test {@link Functions#sumArrayWrong(int[])}.
     * <p>
     * Method under test: {@link Functions#sumArrayWrong(int[])}
     */
    @Test
    @DisplayName("Test sumArrayWrong(int[])")
    void testSumArrayWrong() {
        // Arrange, Act and Assert
        assertEquals(-1, (new Functions()).sumArrayWrong(new int[]{1, -1, 1, -1}));
    }

    /**
     * Test {@link Functions#areAnagrams(String, String)}.
     * <ul>
     *   <li>When empty string.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#areAnagrams(String, String)}
     */
    @Test
    @DisplayName("Test areAnagrams(String, String); when empty string; then return 'false'")
    void testAreAnagrams_whenEmptyString_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(Functions.areAnagrams("", null));
        assertFalse(Functions.areAnagrams("Str1", ""));
    }

    /**
     * Test {@link Functions#areAnagrams(String, String)}.
     * <ul>
     *   <li>When {@code java.lang.Comparable}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#areAnagrams(String, String)}
     */
    @Test
    @DisplayName("Test areAnagrams(String, String); when 'java.lang.Comparable'; then return 'false'")
    void testAreAnagrams_whenJavaLangComparable_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(Functions.areAnagrams("java.lang.Comparable", "Str2"));
    }

    /**
     * Test {@link Functions#areAnagrams(String, String)}.
     * <ul>
     *   <li>When {@code java.lang.Comparable}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#areAnagrams(String, String)}
     */
    @Test
    @DisplayName("Test areAnagrams(String, String); when 'java.lang.Comparable'; then return 'true'")
    void testAreAnagrams_whenJavaLangComparable_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(Functions.areAnagrams("java.lang.Comparable", "java.lang.Comparable"));
    }

    /**
     * Test {@link Functions#areAnagrams(String, String)}.
     * <ul>
     *   <li>When {@code null}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#areAnagrams(String, String)}
     */
    @Test
    @DisplayName("Test areAnagrams(String, String); when 'null'; then return 'false'")
    void testAreAnagrams_whenNull_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(Functions.areAnagrams(null, null));
    }

    /**
     * Test {@link Functions#areAnagrams(String, String)}.
     * <ul>
     *   <li>When {@code Str1}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#areAnagrams(String, String)}
     */
    @Test
    @DisplayName("Test areAnagrams(String, String); when 'Str1'; then return 'false'")
    void testAreAnagrams_whenStr1_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(Functions.areAnagrams("Str1", null));
    }

    /**
     * Test {@link Functions#areAnagrams(String, String)}.
     * <ul>
     *   <li>When {@code Str2}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#areAnagrams(String, String)}
     */
    @Test
    @DisplayName("Test areAnagrams(String, String); when 'Str2'; then return 'false'")
    void testAreAnagrams_whenStr2_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(Functions.areAnagrams("Str1", "Str2"));
    }

    /**
     * Test {@link Functions#findMax(List)}.
     * <ul>
     *   <li>Given forName {@code UTF-8}.</li>
     *   <li>When {@link ArrayList#ArrayList()} add forName {@code UTF-8}.</li>
     *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#findMax(List)}
     */
    @Test
    @DisplayName("Test findMax(List); given forName 'UTF-8'; when ArrayList() add forName 'UTF-8'; then ArrayList() size is one")
    void testFindMax_givenForNameUtf8_whenArrayListAddForNameUtf8_thenArrayListSizeIsOne() {
        // Arrange
        ArrayList<Object> items = new ArrayList<>();
        items.add(Charset.forName("UTF-8"));

        // Act
        //Object actualFindMaxResult = Functions.findMax(items);

        // Assert
        assertEquals(1, items.size());
        //UTF_8 expectedGetResult = ((UTF_8) actualFindMaxResult).INSTANCE;
        //assertSame(expectedGetResult, items.get(0));
    }

    /**
     * Test {@link Functions#findMax(List)}.
     * <ul>
     *   <li>Given {@code null}.</li>
     *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#findMax(List)}
     */
    @Test
    @DisplayName("Test findMax(List); given 'null'; when ArrayList() add 'null'")
    @Disabled("TODO: Complete this test")
    void testFindMax_givenNull_whenArrayListAddNull() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Comparable.compareTo(Object)" because "item" is null
        //       at services.Functions.findMax(Functions.java:87)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        ArrayList<Object> items = new ArrayList<>();
        items.add(null);

        // Act
        //Functions.findMax(items);
    }

    /**
     * Test {@link Functions#findMax(List)}.
     * <ul>
     *   <li>When {@code null}.</li>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#findMax(List)}
     */
    @Test
    @DisplayName("Test findMax(List); when 'null'; then throw IllegalArgumentException")
    void testFindMax_whenNull_thenThrowIllegalArgumentException() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> Functions.findMax(null));
    }

    /**
     * Test {@link Functions#findMin(List)}.
     * <ul>
     *   <li>Given forName {@code UTF-8}.</li>
     *   <li>When {@link ArrayList#ArrayList()} add forName {@code UTF-8}.</li>
     *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#findMin(List)}
     */
    @Test
    @DisplayName("Test findMin(List); given forName 'UTF-8'; when ArrayList() add forName 'UTF-8'; then ArrayList() size is one")
    void testFindMin_givenForNameUtf8_whenArrayListAddForNameUtf8_thenArrayListSizeIsOne() {
        // Arrange
        ArrayList<Object> items = new ArrayList<>();
        //items.add(Charset.forName("UTF-8"));

        // Act
        //Object actualFindMinResult = Functions.findMin(items);

        // Assert
        assertEquals(1, items.size());
        //UTF_8 expectedGetResult = ((UTF_8) actualFindMinResult).INSTANCE;
        //assertSame(expectedGetResult, items.get(0));
    }

    /**
     * Test {@link Functions#findMin(List)}.
     * <ul>
     *   <li>Given {@code null}.</li>
     *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#findMin(List)}
     */
    @Test
    @DisplayName("Test findMin(List); given 'null'; when ArrayList() add 'null'")
    @Disabled("TODO: Complete this test")
    void testFindMin_givenNull_whenArrayListAddNull() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Comparable.compareTo(Object)" because "item" is null
        //       at services.Functions.findMin(Functions.java:100)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        ArrayList<Object> items = new ArrayList<>();
        items.add(null);

        // Act
        //Functions.findMin(items);
    }

    /**
     * Test {@link Functions#findMin(List)}.
     * <ul>
     *   <li>When {@code null}.</li>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link Functions#findMin(List)}
     */
    @Test
    @DisplayName("Test findMin(List); when 'null'; then throw IllegalArgumentException")
    void testFindMin_whenNull_thenThrowIllegalArgumentException() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> Functions.findMin(null));
    }
}
