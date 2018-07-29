package com.group1.core.utils;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

public interface BaseRepository<T,ID extends Serializable> {

    /**
     * 获取对象的hql表名
     * @return tableName
     */
    public String getTableName();

    /**
     * 保存数据对象
     * @param entity
     * @return
     */
    boolean save(T entity);
    /**
     * 根据id查询
     * @param id
     * @param t
     * @return
     */
    T findById(T t,Object id);
    /**
     * 根据表名，字段，参数查询，拼接sql语句
     * @param filed 字段名
     * @param o 字段参数
     * @return
     */
    List<T> findBysql(String filed,Object o);

    Object findObjiectBysql(String filed,Object o);

    /**
     * 多个字段的查询
     * @param map 将你的字段传入map中
     * @return
     */
    List<T> findByMoreFiled(LinkedHashMap<String,Object> map);

    /**
     * 多字段查询分页
     * @param map 以map存储key,value
     * @param start 第几页
     * @param pageNumer 一个页面的条数
     * @return
     */
    List<T> findByMoreFiledpages( LinkedHashMap<String,Object> map, int start, int pageNumer);
    /**
     * 一个字段的分页 
     * @param filed 字段名
     * @param o 字段参数
     * @param start 第几页
     * @param pageNumer 一个页面多少条数据
     * @return
     */
    List<T> findpages(String filed,Object o,int start,int pageNumer);
    /**
     * 根据表的id删除数据
     * @param  entity
     */
    boolean delete(T entity);
    /**
     * 更新对象
     * @param e
     * @return
     */
    boolean update(T e);
    /**
     * 根据传入的map遍历key,value拼接字符串，以id为条件更新 
     * @param map 传入参数放入map中
     * @return
     */
    Integer updateMoreFiled(LinkedHashMap<String,Object> map);


    /**
     * 根据条件查询总条数返回object类型
     * @param map 传入参数放入map中
     * @return
     */
    Object findCount( LinkedHashMap<String,Object> map);
}