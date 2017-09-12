package org.miage.m2.boundary;

import org.miage.m2.entity.Cours;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("cours-service")
public interface CoursReader {

    @RequestMapping(method = RequestMethod.GET, value = "/cours")
    Resources<Cours> read();
}

