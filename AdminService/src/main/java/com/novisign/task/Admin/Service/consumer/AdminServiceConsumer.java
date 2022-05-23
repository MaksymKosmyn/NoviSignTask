package com.novisign.task.Admin.Service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceConsumer {

    @KafkaListener(topics = "license_v1", groupId = "AdminServiceConsumer")
    public void consume(final String id){
        //TODO some ligic
    }
}
