package cc.lau.ribbonhystrix.biz;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc on 18/8/9
 */
@RestController
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @GetMapping("consumer")
    public String consumer(){
        return hystrixService.consumer();
    }
}
