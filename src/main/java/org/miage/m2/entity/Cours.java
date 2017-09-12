package org.miage.m2.entity;

import java.util.Set;
import org.springframework.hateoas.core.Relation;

@Relation(collectionRelation = "cours")
public class Cours {

    private String id;
    private String nom;
    private String description;
    private Set<Long> intervenantsId;
     
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
