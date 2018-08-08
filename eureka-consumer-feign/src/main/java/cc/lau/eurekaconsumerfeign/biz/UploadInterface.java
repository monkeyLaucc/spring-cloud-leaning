package cc.lau.eurekaconsumerfeign.biz;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by cc on 18/8/8
 */
@FeignClient(value = "eureka-client",configuration = UploadConfig.class)
public interface UploadInterface {
    @PostMapping(value = "uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadFile(@RequestPart MultipartFile file);
}