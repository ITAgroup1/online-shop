package com.group1.admin.dao.impl;

import com.group1.admin.dao.MerchantRepository;
import com.group1.core.entity.merchant.Merchant;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("merchantDao")
public class MerchantRepositoryImpl extends JPARepositoryImpl<Merchant, String> implements MerchantRepository {

    @Override
    public Merchant login(String loginName, String password) {
        Merchant merchant = null;
        Query query = entityManager.createQuery("select M From Merchant M Where M.loginName=:loginName and M.password=:password");
        query.setParameter("loginName", loginName);
        query.setParameter("password", password);
        List<Merchant> list = query.getResultList();
        if (list.size() > 0)
            merchant = list.get(0);
        return merchant;
    }

    @Override
    public Merchant checkUnipue(String loginName) {
        Merchant merchant = null;
        Query query = entityManager.createQuery("select M From Merchant M Where M.loginName=:loginName ");
        query.setParameter("loginName", loginName);
        List<Merchant> list = query.getResultList();
        if (list.size() > 0)
            merchant = list.get(0);
        return merchant;
    }
}
