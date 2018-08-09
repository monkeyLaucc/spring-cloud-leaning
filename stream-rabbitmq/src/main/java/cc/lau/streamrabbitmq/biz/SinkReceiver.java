package cc.lau.streamrabbitmq.biz;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by cc on 18/8/9
 */
@EnableBinding(Sink.class)
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        System.out.println("Received=====>"+payload);
    }
}
