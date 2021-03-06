package com.tl666.consumeroder.handler;


import com.tl666.springcloud.pojo.Payment;
import com.tl666.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @Auther: TanLe
 * @Date: 2020/4/22 18:53
 * @Description:
 */
@RestController
@RequestMapping("ConsumerHandler")
@Slf4j
public class ConsumerHandler {
    static final String PAYMENT_URL="http://payment-service";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("getAll")
    public CommonResult<Payment> getAllPayment(){
        CommonResult forObject = restTemplate.getForObject(PAYMENT_URL+"/PaymentHandler/getAll", CommonResult.class);
        forObject.setMessage(forObject.getMessage()+ UUID.randomUUID().toString());
        return forObject;
    }

    @PostMapping("addPayment")
    public CommonResult<Payment> addPayment(Payment payment){
        log.info(payment.toString());
        return restTemplate.postForObject(PAYMENT_URL+"/PaymentHandler/add",payment, CommonResult.class);
    }
}
