package com.group1.core.utils.base;

import com.group1.core.utils.base.model.Sort;

import java.io.Serializable;
import java.util.List;

public interface JpaRepository<T, ID extends Serializable>
        extends PagingAndSortingRepository<T, ID> {

    <S extends T> List<S> save(Iterable<S> entities); //批量保存，并返回对象List
    <S extends T> S saveAndFlush(S entity); //保存并强制同步数据库

    Integer deleteInBatch(Iterable<T> entities); //批量删除 集合对象（后台执行时，生成一条语句执行，用多个or条件）
    Integer deleteAllInBatch();//删除所有 （执行一条语句，如：delete from user）

}
