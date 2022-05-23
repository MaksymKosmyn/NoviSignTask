package com.novisign.task.API.Service.messaging.impl;

import com.novisign.task.API.Service.entity.Project;
import com.novisign.task.API.Service.messaging.ProjectsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class ProjectProducerImpl implements ProjectsProducer {

    @Autowired
    private KafkaTemplate<String, String> licenseTemplate;

    @Override
    public void publish(Project project) {
        licenseTemplate.send("license_v1",project.getId().toString(), project.getStatus().toString());
    }
}
