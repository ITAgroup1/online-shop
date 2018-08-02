package com.group1.admin.dao;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.SystemProfileValueSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MerchantDetailRepositoryTest {

    @Resource
    private MerchantDetailRepository merchantDetailRepository;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSave() {
        MerchantDetail m = new MerchantDetail();
        m.setStatus(MerchantDetail.UNTREATED);
        m.setAddress("Test address3");
        m.setIdcardNum("123456789012345678");
        m.setIntroduction("Test Introduce7");
        m.setMerchantName("Test MerchantName7");
        m.setIdcardPic("testUrl");
        Set<String> shopPiceset =  new HashSet<>();
        shopPiceset.add("test pic set10");
        shopPiceset.add("test pic set1");
        shopPiceset.add("test pic set12");
        m.setShopPic(shopPiceset);
        m.setBusinessPic("bussiner pic12");
        m.setShopId("shopIdId37");
        Merchant merchant = new Merchant();
        merchant.setId("3");
        m.setMerchant(merchant);
        MerchantDetail m2=merchantDetailRepository.insert(m);
        assertNotNull(m2);
        System.out.print(m2);
    }

    @Test
    public void findByMerchatId() {
        MerchantDetail m = merchantDetailRepository.findByMerchatId("3");
        System.out.println(m);
    }

    @Test
    public void updateStatus() {

        merchantDetailRepository.updateStatus("8a5e9d1864f8e5020164f8e5068c0000", MerchantDetail.PASSED);
        MerchantDetail m = merchantDetailRepository.findOne("8a5e9d1864f8e5020164f8e5068c0000");
        System.out.println(m.getStatus());
    }

    @Test
    public void listToVerify() {
        Pageable pageable = new Pageable();
        pageable.setSize(10);
        pageable.setOffset(1);
        Page<MerchantDetail> page = merchantDetailRepository.listToVerify(pageable);
        System.out.println(page);
    }

    @Test
    public void listToUpdateStatus() {
        Pageable pageable = new Pageable();
        pageable.setSize(10);
        pageable.setOffset(1);
        Page<MerchantDetail> page = merchantDetailRepository.listToUpdateStatus(pageable);
        System.out.println(page);
    }

    @Test
    public void findPaasedShop() {
        List<String> list = merchantDetailRepository.findPaasedShop();
        System.out.println(list);
    }
}