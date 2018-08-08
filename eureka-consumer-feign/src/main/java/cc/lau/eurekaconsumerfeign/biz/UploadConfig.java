package cc.lau.eurekaconsumerfeign.biz;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cc on 18/8/8
 */
@Configuration
public class UploadConfig {

    @Bean
    public Encoder feignFormEncoder(){
        return new SpringFormEncoder();
    }

}
