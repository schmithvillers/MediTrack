package com.airtribe.meditrack.util;

import java.util.ArrayList;
import java.util.List;

public class DataStore<T> {

    private final List<T> records;

    public DataStore() {
        records = new ArrayList<>();
    }

    public void add(T object) {
        records.add(object);
    }

    public void remove(T object) {
        records.remove(object);
    }

    public List<T> getAll() {
        return records;
    }
}