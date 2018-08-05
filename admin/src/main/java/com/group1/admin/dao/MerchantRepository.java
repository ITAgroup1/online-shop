package com.group1.admin.dao;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.utils.base.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, String> {

    public Merchant login(String loginName, String password);

    public Merchant checkUnipue(String loginName);

    public Merchant getMerchantByShopId(String shopId);
}
