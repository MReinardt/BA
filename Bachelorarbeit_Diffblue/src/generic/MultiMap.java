package generic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiMap<K, V extends List<? extends Number>> {
    private final Map<K, V> map = new HashMap<>();

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }
}