package com.projectmain.project.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Surveys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(20)")
    private String compenenthtml;

    @Column(columnDefinition = "VARCHAR(20)")
    private String componentreact;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column
    private Audit audit;

    
    public Surveys() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getCompenenthtml() {
        return compenenthtml;
    }

    public void setCompenenthtml(String compenenthtml) {
        this.compenenthtml = compenenthtml;
    }

    public String getComponentreact() {
        return componentreact;
    }

    public void setComponentreact(String componentreact) {
        this.componentreact = componentreact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }
    


}
