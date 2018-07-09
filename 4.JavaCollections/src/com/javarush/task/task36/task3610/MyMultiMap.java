package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int result = 0;

        for (Entry<K, List<V>> pair : map.entrySet()) {
            result += pair.getValue().size();
        }

        return result;
    }

    @Override
    public V put(K key, V value) {
        if (map.containsKey(key)) {
            List<V> keylist = map.get(key);
            if (keylist.size() == repeatCount) keylist.remove(0);
            keylist.add(value);

            return keylist.get(keylist.indexOf(value) - 1);
        } else {
            map.put(key, new ArrayList<V>());
            map.get(key).add(value);
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        if (map.containsKey(key)) {
            V result = null;
            List<V> list = map.get(key);

            if (list.size() > 0) result = list.remove(0);
            if (list.size() == 0) map.remove(key);
            return result;
        }

        return null;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> result = new ArrayList<V>();

        for (Entry<K, List<V>> pair : map.entrySet()) {
            result.addAll(pair.getValue());
        }

        return result;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (V v : values()) if (v.equals(value)) return true;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}