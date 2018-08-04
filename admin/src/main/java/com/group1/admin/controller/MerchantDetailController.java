package com.group1.admin.controller;

import com.group1.admin.service.MerchantDetailService;
import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.utils.ResultBody;
import com.group1.core.utils.base.model.Pageable;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/merchantDetail")
@CrossOrigin(origins = "*", maxAge = 100000)
public class MerchantDetailController {

    @Resource(name = "merchantDetailService")
    private MerchantDetailService service;

    @PostMapping
    @ResponseBody
    public  ResultBody getMerchantDetail(@RequestBody Merchant merchant){
        ResultBody resultBody = new ResultBody();
        if(merchant == null || merchant.getId()==null){
            resultBody.addError("errors","merchant.id  is null");
        }else {
            MerchantDetail merchantDetail = service.getByMerchantId(merchant.getId());
            if(merchantDetail == null){
                resultBody.addError("errors","merchant dosen't have merchantDetail");
            }else{
                resultBody.addData("merchantDetail",merchantDetail);
            }
        }
        return  resultBody;
    }

    @GetMapping("/shop")
    @ResponseBody
    public ResultBody getPassedShop() {
        ResultBody resultBody = new ResultBody();
        resultBody.addData("shops", service.listPassedShop());
        return resultBody;
    }

    @GetMapping("/listUpdate")
    @ResponseBody
    public ResultBody getListToUpdate(Pageable pageable) {
        pageable = pageable != null ? pageable : new Pageable(1, 10);
        ResultBody resultBody = new ResultBody();
        resultBody.addData("list", service.listToUpdateStatus(pageable));
        return resultBody;

    }

    @GetMapping("/listVerify")
    @ResponseBody
    public ResultBody getListToVerify(Pageable pageable) {
        pageable = pageable != null ? pageable : new Pageable(1, 10);
        ResultBody resultBody = new ResultBody();
        resultBody.addData("list", service.listToVerify(pageable));
        return resultBody;
    }

    @PutMapping(value = "/{detailId}/{status}")
    @ResponseBody
    public ResultBody updateStatus(@PathVariable String detailId, @PathVariable Integer status) {

        ResultBody resultBody = new ResultBody();
        if (detailId != null && status != null) {
            MerchantDetail m = service.updateStatus(detailId, status);
            if (m != null) {
                resultBody.setStatus(resultBody.STATUS_SUCCESS);
                resultBody.addData("merchantDetail", m);
            } else {
                resultBody.setStatus(resultBody.STATUS_ERROR);
                resultBody.setMessage("Fail to update status");
            }
        } else if (detailId == null) {
            resultBody.addError("errors", "detailId is null");
        } else if (status == null) {
            resultBody.addError("errors", "status is null");
        }
        return resultBody;
    }

}
