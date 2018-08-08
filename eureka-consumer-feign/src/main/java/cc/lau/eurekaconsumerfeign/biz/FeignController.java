package cc.lau.eurekaconsumerfeign.biz;

import com.netflix.discovery.converters.Auto;
import feign.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by cc on 18/8/8
 */
@RestController
public class FeignController {

    @Autowired
    private ClientInterface clientInterface;

    @Autowired
    private UploadInterface uploadInterface;


    @GetMapping("consumer")
    public String consumer() {
        return clientInterface.getServices();
    }

    @PostMapping(value = "uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestPart MultipartFile file){
        return uploadInterface.uploadFile(file);
    }

}
