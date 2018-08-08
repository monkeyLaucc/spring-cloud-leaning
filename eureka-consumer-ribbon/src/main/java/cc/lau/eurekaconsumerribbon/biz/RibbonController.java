package cc.lau.eurekaconsumerribbon.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cc on 18/8/8
 */
@RestController
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("consumer")
    public String consumer(){
        return restTemplate.getForObject("http://eureka-client/getServices", String.class);
    }

}
