package com.projectmain.project.domain.entity;





import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class category_options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "options_id")
    private Options options;

    @ManyToOne
    @JoinColumn(name = "categories_catalog")
    private categories_catalog Catalog_categories;


    @Embedded
    Audit audit = new Audit();

    @OneToMany(mappedBy = "Category_Options", cascade =  CascadeType.ALL)
    private List<Question_Categories> question_Categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public categories_catalog getCatalog_categories() {
        return Catalog_categories;
    }

    public void setCatalog_categories(categories_catalog catalog_categories) {
        Catalog_categories = catalog_categories;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public List<Question_Categories> getQuestion_Categories() {
        return question_Categories;
    }

    public void setQuestion_Categories(List<Question_Categories> question_Categories) {
        this.question_Categories = question_Categories;
    }

  

}


