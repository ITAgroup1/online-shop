package com.group1.core.utils.base.impl;

import com.group1.core.utils.base.JpaRepository;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import com.group1.core.utils.base.model.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JPARepositoryImpl<T, TD extends Serializable> implements JpaRepository<T, TD> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> clz;

    private String entityName;

    private String idFiled;

    private String tableName;

    @Transactional
    @Override
    public <S extends T> S save(S entity) {
        S result = null;
        try {
            entityManager.persist(entity);
            result = entity;
        } catch (Exception e) {
            System.out.println("---------------保存出错---------------");
            throw e;
        }
        return result;
    }

    @Transactional
    @Override
    public <S extends T> List<S> save(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        try {
            for (S tmp : entities) {
                entityManager.persist(tmp);
                result.add(tmp);
            }
        } catch (Exception e) {
            System.out.println("---------------保存出错---------------");
            throw e;
        }
        return result;
    }

    @Override
    public T findOne(TD td) {
        return (T) entityManager.find(clz, td);
    }

    @Override
    public Iterable<T> findAll() {
        String sql = "from " + entityName;
        Query query = entityManager.createQuery(sql);
        List list = query.getResultList();
        return list;
    }

    @Override
    public Iterable<T> findAll(Iterable<TD> tds) {
        StringBuilder sqlIn = new StringBuilder();
        sqlIn.append("(");
        for (TD key : tds) {
            sqlIn.append("?").append(",");
        }
        sqlIn.replace(sqlIn.length() - 1, sqlIn.length(), ")");
        String sql = "from " + entityName + " where " + idFiled + " in " + sqlIn;
        Query query = entityManager.createQuery(sql);
        int index = 1;
        for (TD key : tds) {
            query.setParameter(index++, key);
        }
        return query.getResultList();
    }

    @Override
    public boolean exists(TD td) {
        return entityManager.find(clz, td) != null;
    }

    @Override
    public Integer count() {
        StringBuilder sql = new StringBuilder("select count(1) from ").append(entityName);
        Query query = entityManager.createQuery(sql.toString());
        return Integer.valueOf(String.valueOf(query.getSingleResult()));
    }

    @Transactional
    @Override
    public Integer delete(TD td) {
        Integer row = 0;
        try {
            T result = entityManager.find(clz, td);
            System.out.println(result);
            entityManager.remove(result);
            row = 1;
        } catch (Exception e) {
            System.out.println("---------------删除出错---------------");
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer delete(T entity) {
        return null;
    }

    @Override
    public Integer delete(Iterable<? extends T> entities) {
        return null;
    }

    @Override
    public Integer deleteAll() {
        return null;
    }

    @Override
    public <S extends T> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public Integer deleteInBatch(Iterable<T> entities) {
        return null;
    }

    @Override
    public Integer deleteAllInBatch() {
        return null;
    }


    @Override
    public Iterable<T> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        int index = 1;
        StringBuilder sql = new StringBuilder("from ").append(getEntityName());
        Sort sort = pageable.getSort();
        if (sort != null) {
            Map<String, String> fieldMap = sort.getFieldMap();
            if (fieldMap != null && !fieldMap.isEmpty()) {
                sql.append(" order by ");
                for(Map.Entry entry : fieldMap.entrySet()){
                    sql.append(entry.getKey()).append(" ").append(entry.getValue()).append(",");
                }
                sql.replace(sql.length()-1,sql.length(),"");
            }
        }
        Query query = entityManager.createQuery(sql.toString())
                .setFirstResult((pageable.getOffset() - 1) * pageable.getSize())
                .setMaxResults(pageable.getSize());
        List<T> data = query.getResultList();
        Page<T> page = new Page<>();
        page.setData(data); // 分页数据
        page.setOffset(pageable.getOffset()); // 当前页数
        page.setSize(data.size());  //当前页面行数
        page.setTotalSize(count()); //总行数
        return page;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public Class getEntityClass() {
        return clz;
    }

    public String getIdFiled() {
        return idFiled;
    }

    public String getEntityName() {
        return entityName;
    }

    public JPARepositoryImpl() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            //参数化类型
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            //返回表示此类型实际类型参数的 Type 对象的数组
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            this.clz = (Class<T>) actualTypeArguments[0];
        } else {
            this.clz = (Class<T>) genericSuperclass;
        }

        this.entityName = this.clz.getSimpleName();

        this.tableName = this.clz.getAnnotation(Table.class).name();

        for (Field field : this.clz.getDeclaredFields()) {
            Id id = field.getAnnotation(Id.class);
            if (id != null) {
                Column column = field.getAnnotation(Column.class);
                if (column != null && !"".equals(column.name())) {
                    this.idFiled = column.name();
                } else {
                    this.idFiled = field.getName();
                }
            }
        }
    }

}
