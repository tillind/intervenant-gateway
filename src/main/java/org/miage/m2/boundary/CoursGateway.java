package org.miage.m2.boundary;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.miage.m2.entity.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cours")
public class CoursGateway {

    private final CoursReader coursReader;

    @Autowired
    public CoursGateway(CoursReader coursReader) {
        this.coursReader = coursReader;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(method = RequestMethod.GET, value = "/noms")
    public Resources<Resource<Cours>> noms() {
        Collection<Cours> content = this.coursReader.read().getContent();
        List<Resource<Cours>> listeCours = new ArrayList<>();
        content.forEach(c -> listeCours.add(new Resource<>(c)));
        return new Resources<>(listeCours);
    }

    public Resources<Resource<Cours>> fallback() {
        Cours c = new Cours();
        c.setNom("unavailable");
        List<Resource<Cours>> listeCours = new ArrayList<>();
        listeCours.add(new Resource<>(c));
        return new Resources<>(listeCours);
    }

}
