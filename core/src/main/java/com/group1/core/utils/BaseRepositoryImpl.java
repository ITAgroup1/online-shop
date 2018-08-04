package com.group1.core.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public abstract class BaseRepositoryImpl <T,ID extends Serializable> implements BaseRepository<T,ID> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public T save(T entity) {
        T result = null;
        try {
            entityManager.persist(entity);
            result = entity;
        }catch (Exception e){
            System.out.println("---------------保存出错---------------");
            throw e;
        }
        return result;
    }

    @Override
    public T findById(T t, Object id) {
        return (T)entityManager.find(t.getClass(),id);
    }

    @Override
    public List<T> findByFiled(String filed, Object o) {
        String sql="from "+getTableName()+" u WHERE u."+filed+"=?";
        System.out.println(sql+"--------sql语句-------------");
        Query query=entityManager.createQuery(sql);
        query.setParameter(1,o);
        List list= query.getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public Object findObjiectBysql(String filed, Object o) {
        String sql="from "+getTableName()+" u WHERE u."+filed+"=?";
        System.out.println(sql+"--------sql语句-------------");
        Query query=entityManager.createQuery(sql);
        query.setParameter(1,o);
        entityManager.close();
        return query.getSingleResult();
    }

    @Override
    public List<T> findByMoreFiled(LinkedHashMap<String, Object> map) {
        StringBuilder sql= new StringBuilder("from " + getTableName() + " u WHERE ");
        Set<String> set=null;
        set=map.keySet();
        List<String> list=new ArrayList<>(set);
        List<Object> filedlist=new ArrayList<>();
        for (String filed:list){
            sql.append("u.").append(filed).append("=? and ");
            filedlist.add(filed);
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 4));
        System.out.println(sql+"--------sql语句-------------");
        Query query=entityManager.createQuery(sql.toString());
        for (int i=0;i<filedlist.size();i++){
            query.setParameter(i+1,map.get(filedlist.get(i)));
        }
        List resultList= query.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public List<T> findByMoreFiledpages(LinkedHashMap<String, Object> map, int start, int pageNumber) {
        StringBuilder sql= new StringBuilder("from " + getTableName() + " u WHERE ");
        Set<String> set=null;
        set=map.keySet();
        List<String> list=new ArrayList<>(set);
        List<Object> filedList=new ArrayList<>();
        for (String filed:list){
            sql.append("u.").append(filed).append("=? and ");
            filedList.add(filed);
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 4));
        System.out.println(sql+"--------sql语句-------------");
        Query query=entityManager.createQuery(sql.toString());
        for (int i=0;i<filedList.size();i++){
            query.setParameter(i+1,map.get(filedList.get(i)));
        }
        query.setFirstResult((start-1)*pageNumber);
        query.setMaxResults(pageNumber);
        List resultList= query.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public List<T> findpages(String filed, Object o, int start, int pageNumer) {
        String sql="from "+getTableName()+" u WHERE u."+filed+"=?";
        System.out.println(sql+"--------page--sql语句-------------");
        List list=new ArrayList<>();
        try {
            Query query=entityManager.createQuery(sql);
            query.setParameter(1,o);
            query.setFirstResult((start-1)*pageNumer);
            query.setMaxResults(pageNumer);
            list= query.getResultList();
            entityManager.close();
        }catch (Exception e){
            System.out.println("------------分页错误---------------");
        }

        return list;
    }

    @Transactional
    @Override
    public boolean delete(Object entity) {
        boolean flag=false;
        try {
            entityManager.remove(entityManager.merge(entity));
            flag=true;
        }catch (Exception e){
            System.out.println("---------------删除出错---------------");
        }
        return flag;
    }

    @Transactional
    @Override
    public boolean update(Object entity) {
        boolean flag = false;
        try {
            entityManager.merge(entity);
            flag = true;
        } catch (Exception e) {
            System.out.println("---------------更新出错---------------");
        }
        return flag;
    }

    @Transactional
    @Override
    public Integer updateMoreFiled(LinkedHashMap<String, Object> map) {
        StringBuilder sql= new StringBuilder("UPDATE " + getTableName() + " AS u SET ");
        Set<String> set=null;
        set=map.keySet();
        List<String> list=new ArrayList<>(set);
        for (int i=0;i<list.size()-1;i++){
            if ("java.lang.String".equals(map.get(list.get(i)).getClass().getTypeName())){
                sql.append("u.").append(list.get(i)).append("='").append(map.get(list.get(i))).append("' , ");
            }else {
                sql.append("u.").append(list.get(i)).append("=").append(map.get(list.get(i))).append(" , ");
            }
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 2));
        sql.append("where u.id=? ");
        System.out.println(sql+"--------sql语句-------------");
        int result=0;
        try {
            Query query=entityManager.createQuery(sql.toString());
            query.setParameter(1,map.get("id"));
            result= query.executeUpdate();
        }catch (Exception e){
            System.out.println("更新出错-----------------------");
            e.printStackTrace();

        }
        return result;
    }

    @Override
    public Object findCount(LinkedHashMap<String, Object> map) {
        StringBuilder sql= new StringBuilder("select count(u) from " + getTableName() + " u WHERE ");
        Set<String> set=null;
        set=map.keySet();
        List<String> list=new ArrayList<>(set);
        List<Object> filedList=new ArrayList<>();
        for (String filed:list){
            sql.append("u.").append(filed).append("=? and ");
            filedList.add(filed);
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 4));
        System.out.println(sql+"--------sql语句-------------");
        Query query=entityManager.createQuery(sql.toString());
        for (int i=0;i<filedList.size();i++){
            query.setParameter(i+1,map.get(filedList.get(i)));
        }
        return query.getSingleResult();
    }

}