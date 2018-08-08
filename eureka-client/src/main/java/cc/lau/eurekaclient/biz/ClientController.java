package cc.lau.eurekaclient.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.POST;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cc on 18/8/8
 */
@RestController
public class ClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @GetMapping("getServices")
    public String getServices(){
        List<String> services = discoveryClient.getServices();
        System.out.println("Services===>:"+Arrays.toString(services.toArray()));
        return "Service:"+port+":"+Arrays.toString(services.toArray());
    }

    @PostMapping(value = "uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uplaodFile(@RequestPart(value = "file")MultipartFile file){
        return "Service:"+port+":"+file.getName();
    }
}
