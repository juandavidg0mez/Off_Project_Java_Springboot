package com.projectmain.project.domain.entity;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

import io.micrometer.common.lang.NonNull;

@Entity
public class categories_catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    Audit audit = new Audit();

    @NonNull
    @NotEmpty(message = "Recuerda Rellenar estos Canmpos")
    @Column(columnDefinition = "VARCHAR(225)")
    private String name;

    @ManyToMany
    @JoinTable(
        name = "survey_category",
        joinColumns = @JoinColumn(name = "category_id"),
        inverseJoinColumns = @JoinColumn(name = "survey_id")
    )
    private List<Surveys> surveys;

    @OneToMany(mappedBy = "Catalog_categories", cascade = CascadeType.ALL)
    private List<category_options> Category_Options;
    
    public categories_catalog() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Surveys> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Surveys> surveys) {
        this.surveys = surveys;
    }

    public List<category_options> getCategory_Options() {
        return Category_Options;
    }

    public void setCategory_Options(List<category_options> category_Options) {
        Category_Options = category_Options;
    }

    
}   
