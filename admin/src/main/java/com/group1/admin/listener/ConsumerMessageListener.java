package com.group1.admin.listener;

import com.group1.admin.service.ComplaintService;
import com.group1.admin.service.MerchantDetailService;
import com.group1.core.entity.complaint.Complaint;
import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.JsonUtil;
import com.group1.core.utils.ResultBody;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Map;

public class ConsumerMessageListener implements MessageListener {

    @Resource(name = "complaintService")
    private ComplaintService complaintService;
    @Resource(name = "merchantDetailService")
    private MerchantDetailService merchantDetailService;

    @Override
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        TextMessage tm = (TextMessage) message;
        try {
            String context = tm.getText();
            ResultBody resultBody = (ResultBody) JsonUtil.jsonToObject(context, ResultBody.class);
            String type = (String) resultBody.getData("type");
            if ("Complaint".equals(type)) {
                Complaint complaint =
                        JsonUtil.mapToObject((Map) resultBody.getData("complaint"), Complaint.class);
                if (complaintService.add(complaint) == null) {
                    System.out.println("Jms: add complaint fail");
                } else {
                    System.out.println("Jms: add complaint succeed");
                }
            } else if ("MerchantDetail".equals(type)) {
                MerchantDetail merchantDetail =
                        JsonUtil.mapToObject((Map) resultBody.getData("merchantDetail"), MerchantDetail.class);

                if (merchantDetailService.add(merchantDetail) == null) {
                    System.out.println("Jms: add merchantDetail fail");
                } else {
                    System.out.println("Jms: add merchantDetail succeed");
                }


            }
            //call method of the service
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
