package com.group1.admin.service.impl;

import com.group1.admin.dao.MerchantDetailRepository;
import com.group1.admin.dao.MerchantRepository;
import com.group1.admin.service.MerchantDetailService;
import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("merchantDetailService")
public class MerchantDetailServiceImpl implements MerchantDetailService {

    @Resource(name = "merchantDetailDao")
    private MerchantDetailRepository merchantDetailRepository;
    @Resource(name = "merchantDao")
    private MerchantRepository merchantRepository;

    @Override
    @Transactional
    public MerchantDetail add(MerchantDetail merchantDetail) {
        System.out.println(merchantDetail);
        System.out.println(merchantDetail.getMerchant().getId());
        String merchantId = merchantDetail.getMerchant().getId();
        if (merchantId == null) {
            return null;
        }
        Merchant merchant = merchantRepository.findOne(merchantId);
        if (merchant != null) {
            if (merchantDetail.getStatus() == MerchantDetail.UNTREATED) {
                merchantDetail.setMerchant(merchant);
                merchant.setMerchantDetail(merchantDetail);
                merchantRepository.save(merchant);
                merchantDetailRepository.save(merchantDetail);
                return merchantDetail;
            } else if (merchantDetail.getStatus() == MerchantDetail.REJECTED) {
                merchantDetail.setStatus(MerchantDetail.UNTREATED);
                return update(merchantDetail);
            }

        } else {
            return null;
        }
        return null;
    }

    @Override
    public MerchantDetail getByMerchantId(String merchantId) {

        return merchantDetailRepository.findByMerchatId(merchantId);
    }

    @Override
    @Transactional
    public MerchantDetail updateStatus(String id, Integer status) {
        return merchantDetailRepository.updateStatus(id, status);
    }

    @Override
    public Page<MerchantDetail> listToVerify(Pageable pageable) {
        return merchantDetailRepository.listToVerify(pageable);
    }

    @Override
    public Page<MerchantDetail> listToUpdateStatus(Pageable pageable) {
        return merchantDetailRepository.listToUpdateStatus(pageable);
    }

    @Override
    public List<String> listPassedShop() {
        return merchantDetailRepository.findPaasedShop();
    }

    @Override
    @Transactional
    public MerchantDetail update(MerchantDetail merchantDetail) {
        MerchantDetail m = merchantDetailRepository.findOne(merchantDetail.getId());
        if (m != null) {
            System.out.println("id:" + m.getId());
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
            return merchantDetailRepository.save(m);
        } else {
            return null;
        }

    }
}
