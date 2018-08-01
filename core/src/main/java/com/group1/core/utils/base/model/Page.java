package com.group1.core.utils.base.model;

import java.util.List;

public class Page<T> {
    private Integer offset; // 当前页数
    private Integer size;   // 当前大小
    private Integer totalSize; // 总大小
    private List<T> data;   //页面数据

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

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "offset=" + offset +
                ", size=" + size +
                ", totalSize=" + totalSize +
                ", data=" + data +
                '}';
    }
}
