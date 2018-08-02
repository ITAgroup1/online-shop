package com.group1.admin.dao.impl;

import com.group1.admin.dao.MerchantDetailRepository;
import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;

@Repository("merchantDetailDao")
public class MerchantDetailRepositoryImpl extends JPARepositoryImpl<MerchantDetail, String> implements MerchantDetailRepository {

    @Override
    @Transactional
    public MerchantDetail insert(MerchantDetail merchantDetail) {
        Merchant merchant = entityManager.find(Merchant.class, merchantDetail.getMerchant().getId());
        if (merchant != null) {
            merchantDetail.setMerchant(merchant);
            merchant.setMerchantDetail(merchantDetail);
            entityManager.persist(merchant);
            entityManager.persist(merchantDetail);
            return merchantDetail;
        }
        return null;
    }

    @Override
    @Transactional
    public MerchantDetail update(MerchantDetail merchantDetail) {
        MerchantDetail m = entityManager.find(MerchantDetail.class, merchantDetail.getId());
        if (m != null) {
            if (merchantDetail.getBusinessPic() != null)
                m.setBusinessPic(merchantDetail.getBusinessPic());
            if (merchantDetail.getShopPic() != null)
                m.setShopPic(merchantDetail.getShopPic());
            if (merchantDetail.getAddress() != null)
                m.setAddress(merchantDetail.getAddress());
            if (merchantDetail.getIdcardNum() != null)
                m.setIdcardNum(merchantDetail.getIdcardNum());
            if (merchantDetail.getIdcardPic() != null)
                m.setIdcardPic(merchantDetail.getIdcardPic());
            if (merchantDetail.getIntroduction() != null)
                m.setIntroduction(merchantDetail.getIntroduction());
            if (merchantDetail.getMerchantName() != null)
                m.setMerchantName(merchantDetail.getMerchantName());
            if (merchantDetail.getStatus() != null)
                m.setStatus(merchantDetail.getStatus());
            entityManager.persist(m);
        }
        return m;
    }

    @Override
    public MerchantDetail findByMerchatId(String merchantId) {
        Query query = entityManager.createQuery("Select M From MerchantDetail M Where M.merchant.id =:merchantId");
        query.setParameter("merchantId", merchantId);
        List<MerchantDetail> list = query.getResultList();
        MerchantDetail merchantDetail = null;
        if (list.size() > 0)
            merchantDetail = list.get(0);
        return merchantDetail;
    }

    @Override
    @Transactional
    public MerchantDetail updateStatus(String id, Integer status) {
        MerchantDetail merchantDetail = (MerchantDetail) findOne(id);
        merchantDetail.setStatus(status);
        return save(merchantDetail);
    }

    @Override
    public Page<MerchantDetail> listToVerify(Pageable pageable) {

        Query query = entityManager.createQuery("Select M From MerchantDetail M Where M.status =:untreated");
        query.setParameter("untreated", MerchantDetail.UNTREATED);
        query.setFirstResult((pageable.getOffset() - 1) * pageable.getSize())
                .setMaxResults(pageable.getSize());
        List<MerchantDetail> data = query.getResultList();
        Page<MerchantDetail> page = new Page<>();
        page.setData(data); // 分页数据
        page.setOffset(pageable.getOffset()); // 当前页数
        page.setSize(data.size());  //当前页面行数
        Query query1 = entityManager.createQuery("Select COUNT(1)From MerchantDetail M Where M.status =:untreated");
        query1.setParameter("untreated", MerchantDetail.UNTREATED);
        page.setTotalSize(Integer.valueOf(query1.getSingleResult().toString())); //总行数
        return page;
    }

    @Override
    public Page<MerchantDetail> listToUpdateStatus(Pageable pageable) {
        Query query = entityManager.createQuery("Select M From MerchantDetail M Where M.status not in(:untreated,:rejected) ");
        query.setParameter("untreated", MerchantDetail.UNTREATED);
        query.setParameter("rejected", MerchantDetail.REJECTED);
        int total = query.getMaxResults();
        query.setFirstResult((pageable.getOffset() - 1) * pageable.getSize())
                .setMaxResults(pageable.getSize());
        List<MerchantDetail> data = query.getResultList();
        Page<MerchantDetail> page = new Page<>();
        page.setData(data); // 分页数据
        page.setOffset(pageable.getOffset()); // 当前页数
        page.setSize(data.size());  //当前页面行数
        Query query1 = entityManager.createQuery("Select COUNT(1)From MerchantDetail M Where M.status not in(:untreated,:rejected) ");
        query1.setParameter("untreated", MerchantDetail.UNTREATED);
        query1.setParameter("rejected", MerchantDetail.REJECTED);
        page.setTotalSize(Integer.valueOf(query1.getSingleResult().toString())); //总行数
        return page;
    }

    @Override
    public List<String> findPaasedShop() {
        Query query = entityManager.createQuery("Select M.shopId From MerchantDetail M Where M.status =:status");
        query.setParameter("status", MerchantDetail.PASSED);
        List<String> list = query.getResultList();
        return list;
    }

}
