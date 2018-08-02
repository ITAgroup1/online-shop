package com.group1.client.service;

import com.group1.client.dao.ShopRepository;
import com.group1.core.entity.recipe.Recipe;
import com.group1.core.entity.shop.Shop;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ShopServiceTest {

    @Resource
    private ShopService shopService;

    @Resource
    private ShopRepository shopRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        Shop shop = new Shop();
        shop.setShopName("ITA_NO.1");
        Set<String> shopPic = new HashSet<>();
        shopPic.add("http://tgi12.jia.com/120/949/20949866.jpg");
        shopPic.add("http://tgi1.jia.com/120/949/20949872.jpg");
        shopPic.add("http://tgi13.jia.com/120/949/20949877.jpg");
        shop.setBusinessPic("https://pic.baike.soso.com/ugc/baikepic2/16962/cut-20180128164556-1372367303_jpg_330_264_13047.jpg/300");
        shop.setDistributionCost(10.00);
        shop.setScore(4.81);
        shop.setServiceStartTime(System.currentTimeMillis()-1000*3600*12);
        shop.setServiceEndTime(System.currentTimeMillis());
        shop.setServiceRange(10);
        shop.setMerchantDetailId("123456");
        shop.setAddress("珠海市唐家软件园路1号南方软件园西区B5");
        shop.setIntroduction("东方海外货柜航运有限公司（OOCL），为世界上颇具规模之综合性国际货柜运输、物流及码头公司之一，为客户提供全面的物流及运输服务。" +
                "其航线遍及亚洲 、欧洲、北美、 地中海、 印度次大陆、中东及澳洲/纽西兰等地。东方海外为客户提供以客为尊的物流方案，其精益求精，不断创新的服务精神一向享誉业内。" +
                "东方海外是全球最具规模的集装箱运输和物流服务供应商之一，在全球个国家近60个国家设有230多家分支结构，雇用员工超过6,000名。" +
                "东方海外率先在中国提供全线物流及运输服务，在信息服务方面亦是业内先驱。");
        shop.setShopPic(shopPic);
        Recipe recipe = new Recipe();
        recipe.setPrice(10);
        recipe.setRecipeName("红烧肉");
        recipe.setRecipeDetail("hahahaha");
        recipe.setRecipePic("https://www.fancai.com//Uploads/MeiShi/2018-07-10/5b44623809ae7.jpg");

        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);
        recipes.add(recipe);

        shop.setRecipes(recipes);

        Shop result = shopRepository.save(shop);
        Assert.assertNotNull(result);
    }
}