package com.group1.client.controller;

import com.group1.client.service.OrderService;
import com.group1.core.entity.client.Client;
import com.group1.core.entity.order.Order;
import com.group1.core.utils.ResultBody;
import com.group1.core.utils.base.model.Page;
import com.group1.core.utils.base.model.Pageable;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.PUT;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource(name = "orderService")
    private OrderService orderService;

    @PostMapping
    @ResponseBody
    public ResultBody add(@Valid Order order, Errors errors){
        ResultBody resultBody = new ResultBody();
        if(!errors.hasErrors()){
            resultBody.addData("order",orderService.save(order));
        }else{
            resultBody.addErrors(errors.getAllErrors());
        }
        return resultBody;
    }

    @DeleteMapping("/{orderId}")
    @ResponseBody
    public ResultBody delete(@PathVariable String orderId){
        ResultBody resultBody = new ResultBody();
        Integer result = orderService.delete(orderId);
        if(result==1){
            resultBody.addData("result",result);
        }else{
            resultBody.addError("errors","fail to delete");
        }
        return resultBody;
    }

    @PutMapping("/{orderId}/{status}")
    @ResponseBody
    public ResultBody update(@PathVariable String orderId , @PathVariable Integer status){
        ResultBody resultBody = new ResultBody();
        Order order = orderService.update(orderId,status);
        if(order!=null){
            resultBody.addData("order",order);
        }else{
            resultBody.addError("errors","fail to update");
        }
        return resultBody;
    }

    @GetMapping("/{offset}/{size}")
    @ResponseBody
    public ResultBody findAll(@PathVariable Integer offset,@PathVariable Integer size){
        ResultBody resultBody = new ResultBody();
        Pageable pageable = new Pageable();
        pageable.setOffset(offset);
        pageable.setSize(size);
        resultBody.addData("orderList",orderService.findAll(pageable));
        return resultBody;
    }


}
