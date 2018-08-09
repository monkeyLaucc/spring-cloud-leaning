package cc.lau.ribbonhystrix.biz;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cc on 18/8/9
 */
@Service
public class HystrixService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer(){
        return restTemplate.getForObject("http://eureka-client/getServices", String.class);
    }

    public String fallback(){
        return "the service running fallback !!!";
    }

}
