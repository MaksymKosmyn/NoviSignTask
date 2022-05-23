package com.novisign.task.API.Service.messaging;

import com.novisign.task.API.Service.entity.Project;

public interface ProjectsProducer {

    public void publish(Project project);

}
