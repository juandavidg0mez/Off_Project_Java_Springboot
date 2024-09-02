package com.projectmain.project.domain.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
public class Surveys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(columnDefinition = "VARCHAR(20)")
    private String compenenthtml;

    @Column(columnDefinition = "VARCHAR(20)")
    private String componentreact;

    @NotEmpty
    @NotNull(message = "Falta Descripcion para guardar")
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotEmpty
    @NotNull(message = "Ten encuenta que para para guardar La encuenta debe tener un nombre")
    @Column(columnDefinition = "TEXT")
    private String name;

    @Embedded
    Audit audit = new Audit();

    @ManyToMany(mappedBy = "surveys" , cascade = CascadeType.ALL)
    private List<categories_catalog> categories_catalogs;

    @OneToMany(mappedBy = "surveys", cascade = CascadeType.ALL)
    private List<Chapters> chapters;
    
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


    public List<categories_catalog> getCategories_catalogs() {
        return categories_catalogs;
    }


    public void setCategories_catalogs(List<categories_catalog> categories_catalogs) {
        this.categories_catalogs = categories_catalogs;
    }


  
}
