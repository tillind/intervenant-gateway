package org.miage.m2.boundary;

import org.miage.m2.entity.Cours;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface CoursWriter {
    @Gateway(requestChannel = "output")
    void write(Cours cours);
}
