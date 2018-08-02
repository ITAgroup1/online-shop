package com.group1.merchant.dao.impl;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.utils.base.impl.JPARepositoryImpl;
import com.group1.merchant.dao.MerchantRepository;
import org.springframework.stereotype.Repository;

@Repository("merchantRepository")
public class MerchantRepositoryImpl extends JPARepositoryImpl<Merchant,String> implements MerchantRepository {
}
