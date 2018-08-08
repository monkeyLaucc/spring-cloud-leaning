package cc.lau.eurekaconsumer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cc on 18/8/8
 */
@RestController
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("consumer")
    public String consumer(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKA-CLIENT");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/getServices";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

}
