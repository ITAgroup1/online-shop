package com.group1.core.utils.base;

import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import com.group1.core.utils.base.model.Sort;

import java.io.Serializable;

public interface PagingAndSortingRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

    Iterable<T> findAll(Sort sort);// 仅排序
    Page<T> findAll(Pageable pageable);// 分页和排序
}
