package me.dan.tournamentprogram.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class Manager<T> {

    private final Map<Integer, T> map;

    public Manager() {
        this.map = new HashMap<>();
    }

    public T getById(int id) {
        return map.get(id);
    }

    public int getNextFreeId() {
        if (map.isEmpty()) {
            return 1;
        }

        for (int i = 1; i <= map.size(); i++) {
            if (map.containsKey(i)) {
                continue;
            }

            return i;
        }

        return map.size() + 1;
    }

    public void insert(int key, T value) {
        map.put(key, value);
    }

    public Map<Integer, T> getMap() {
        return map;
    }

    public Collection<T> getAll() {
        return getMap().values();
    }

}
