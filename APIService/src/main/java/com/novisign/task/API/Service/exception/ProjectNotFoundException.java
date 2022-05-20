package com.novisign.task.API.Service.exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String cause) {
        super("Project not found with " + cause);
    }
}
