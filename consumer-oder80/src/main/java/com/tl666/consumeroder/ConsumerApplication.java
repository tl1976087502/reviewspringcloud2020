package com.tl666.consumeroder;

import com.tl666.balancerule.MyBalancerule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Auther: TanLe
 * @Date: 2020/4/22 18:52
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "payment-service",configuration = MyBalancerule.class)
public class ConsumerApplication {
    public static void main(String[] args){
            SpringApplication.run(ConsumerApplication.class,args);
    }
}
