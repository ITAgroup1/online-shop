package com.group1.core.utils.base.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Sort {

    private Map<String, String> fieldMap = new LinkedHashMap<>();

    private final static String ASC = "ASC";
    private final static String DESC = "DESC";

    public Sort(String key, String direction) {
        this.fieldMap.put(key, direction);
    }

    public Sort(Map<String, String> fieldMap) {
        this.fieldMap = fieldMap;
    }


    static Sort by(Map<String, String> fieldMap) {
        if (fieldMap == null || fieldMap.isEmpty()) return null;
        for (Map.Entry entry : fieldMap.entrySet()) {
            if (!ASC.equals(entry.getValue().toString().toUpperCase()) && !DESC.equals(entry.getValue().toString().toUpperCase())) {
                throw new RuntimeException("Sort by is ERROR , because fieldMap's value is not in (ASC,DESC)");
            }
        }
        return new Sort(fieldMap);
    }

    static Sort by(Sort sort) {
        if (sort == null) return null;

        Map<String, String> fieldMap = sort.getFieldMap();

        if (fieldMap == null || fieldMap.isEmpty()) return null;

        return Sort.by(fieldMap);
    }

    public Map<String, String> getFieldMap() {
        return fieldMap;
    }

}
