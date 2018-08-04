package com.group1.merchant.service.impl;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.jerseyPoolingClientFactory.JerseyPoolingClientFactoryImpl;
import com.group1.core.utils.JsonUtil;
import com.group1.core.utils.PropertiesUtils;
import com.group1.core.utils.ResultBody;
import com.group1.core.utils.jms.ProducerService;
import com.group1.merchant.dao.MerchantDetailRepository;
import com.group1.merchant.service.MerchantDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.ws.rs.client.Client;
import java.util.Map;

@Service("merchantDetailService")
@Transactional
public class MerchantDetailServiceImpl implements MerchantDetailService {

    @Resource
    private JerseyPoolingClientFactoryImpl jerseyPoolingClient;

    @Resource
    private MerchantDetailRepository merchantDetailRepository;

    @Resource(name = "producerService")
    private ProducerService producerService;

    @Resource(name = "queueDestination")
    private Destination destination;

    private String adminServer = PropertiesUtils.getProperty("admin.server");

    @Override
    public MerchantDetail sendMerchantDetail(MerchantDetail merchantDetail) {
        ResultBody resultBody = new ResultBody();
        resultBody.addData("merchantDetail", merchantDetail);
        resultBody.addData("type","MerchantDetail");
        String merchantDetailJson = JsonUtil.objectToJson(resultBody);

        producerService.sendMessage(destination,merchantDetailJson);
        return merchantDetail;
    }

    @Override
    public MerchantDetail submitMerchantDetail(MerchantDetail merchantDetail) {
        sendMerchantDetail(merchantDetail);
        return merchantDetail;
    }

    @Override
    public MerchantDetail modifyMerchantDetail(MerchantDetail merchantDetail) {
        sendMerchantDetail(merchantDetail);
        return merchantDetail;
    }

    @Override
    public MerchantDetail verifyMerchantDetail(Merchant merchant) {
        return getMerchantDetail(merchant);
    }

    @Override
    public MerchantDetail getMerchantDetail(Merchant merchant) {
        MerchantDetail merchantDetail = null;
        try {
            Client client = jerseyPoolingClient.getObject();
            String path = PropertiesUtils.getProperty("merchantDetail.verify.path");
            ResultBody resultBody = JerseyJsonService.post(client, adminServer, path, merchant, ResultBody.class);
            if(resultBody == null)
                return merchantDetail;
            if(resultBody.getStatus() == ResultBody.STATUS_ERROR)
                return merchantDetail;
            System.out.println( resultBody.getData("merchantDetail").getClass().getName());
            merchantDetail = JsonUtil.mapToObject((Map) resultBody.getData("merchantDetail"),MerchantDetail.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return merchantDetail;
    }

    @Override
    public Merchant getMerchantDetail(String shopId) {
        MerchantDetail merchantDetail = merchantDetailRepository.getMerchantDetailByShopId(shopId);
        return merchantDetail.getMerchant();
    }
}
