package services;

import java.util.Arrays;
import java.util.List;

public class Functions {

    //region simple methods

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0){
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return a / b;
    }

    //endregion

    //region wrong methods

    public int addWrong(int a, int b) {
        // Fehler: Verwendet Subtraktion statt Addition
        return a - b;
    }

    public int divideWrong(int a, int b) {
        // Fehler: Keine Prüfung auf Division durch null
        return a / b;
    }

    public boolean isEvenWrong(int number) {
        // Fehler: Prüft auf ungerade Zahlen anstelle von geraden
        return number % 2 != 0;
    }

    public boolean containsElementWrong(List<Integer> list, int element) {
        // Fehler: Gibt immer false zurück
        for (int i : list) {
            if (i == element) {
                return false; // sollte true sein
            }
        }
        return false;
    }

    public int sumArrayWrong(int[] array) {
        int sum = 0;
        // Fehler: Startet die Schleife bei 1 statt bei 0
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    //endregion

    //region complex methods

    public static boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty() || str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toLowerCase().toCharArray();
        char[] charArray2 = str2.toLowerCase().toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    //endregion

    //region generic methods

    public static <T extends Comparable<T>> T findMax(List<T> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        T max = items.get(0);
        for (T item : items) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T findMin(List<T> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        T min = items.get(0);
        for (T item : items) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }

    //endregion

}