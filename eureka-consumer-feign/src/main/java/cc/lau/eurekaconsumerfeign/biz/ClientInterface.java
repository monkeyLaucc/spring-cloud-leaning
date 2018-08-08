package cc.lau.eurekaconsumerfeign.biz;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by cc on 18/8/8
 */
@FeignClient("eureka-client")//调用哪个服务
public interface ClientInterface {

    @GetMapping("getServices")//调用服务暴露的接口
    String getServices();
}
