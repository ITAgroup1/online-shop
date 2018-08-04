package com.group1.admin.service;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class MerchantDetailServiceTest {

    @Resource(name="merchantDetailService")
    private MerchantDetailService service;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        MerchantDetail m = new MerchantDetail();
        m.setStatus(MerchantDetail.UNTREATED);
        m.setAddress("Test 5");
        m.setIdcardNum("123456789012345678");
        m.setIntroduction("Test Intruce4");
        m.setMerchantName("Test MerName4");
        m.setIdcardPic("testUrl");
        Set<String> shopPiceset =  new HashSet<>();
        shopPiceset.add("test pc et");
        shopPiceset.add("test pic st");
        shopPiceset.add("test pc se");
        m.setShopPic(shopPiceset);
        m.setBusinessPic("bussiner pic255");
        m.setShopId("opIdI47");
        Merchant merchant = new Merchant();
        merchant.setId("8a5e9d1864fdd29a0164fdd47a690000");
        m.setMerchant(merchant);
        MerchantDetail m2=service.add(m);
        assertNotNull(m2);
        System.out.print(m2);
    }

    @Test
    public void updateStatus() {
        MerchantDetail m2=service.updateStatus("8a5e9d1864f937c40164f937c9670000",MerchantDetail.REJECTED);
        assertNotNull(m2);
    }

    @Test
    public void update() {
        MerchantDetail m = new MerchantDetail();
        m.setId("8a5e9d1864fef81f0164fef826630000");
        m.setStatus(MerchantDetail.NO_PASSED);
        m.setAddress("Test address3");
        m.setIdcardNum("123456789012345678");
        m.setIntroduction("Test Introduce7");
        m.setMerchantName("Service update hantName7");
        m.setIdcardPic("testUrl");
        Set<String> shopPiceset =  new HashSet<>();
        shopPiceset.add("test pic set1010");
        shopPiceset.add("test pic set001");
        shopPiceset.add("test pic set100");
        m.setShopPic(shopPiceset);
        m.setBusinessPic("bussiner pic102");
        m.setShopId("Service update shopIdId07");
        MerchantDetail m2=service.update(m);
        System.out.print(m2);
        assertNotNull(m2);

    }


    @Test
    public void listToVerify() {
        Pageable pageable = new Pageable();
        pageable.setSize(4);
        pageable.setOffset(1);
        Page<MerchantDetail> page = service.listToVerify(pageable);
        System.out.println(page);
    }

    @Test
    public void listToUpdateStatus() {
        Pageable pageable = new Pageable();
        pageable.setSize(10);
        pageable.setOffset(1);
        Page<MerchantDetail> page = service.listToUpdateStatus(pageable);
        for(MerchantDetail m: page.getData()) {

            System.out.println("id:"+m.getId()+"  "+m.getMerchant());
        }
        System.out.println(page);
    }

    @Test
    public void listPassedShop() {
        List<String> list = service.listPassedShop();
        System.out.println(list);
    }
}