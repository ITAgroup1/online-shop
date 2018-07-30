package com.group1.core.utils.base.model;

import java.io.Serializable;

public class Pageable implements Serializable {

    private Sort sort;
    private Integer offset;
    private Integer size;
    private Integer next;

    public Pageable() {
    }

    public Pageable(Integer offset, Integer size) {
        this(offset, size, null);
    }

    public Pageable(Integer offset, Integer size, Sort sort) {
        this.offset = offset;
        this.size = size;
        this.next = offset + size - 1;
        if (sort != null) this.sort = Sort.by(sort);
        else this.sort = null;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
