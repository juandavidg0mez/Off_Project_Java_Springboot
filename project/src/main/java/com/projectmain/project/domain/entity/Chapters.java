package com.projectmain.project.domain.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Chapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    Audit audit = new Audit();

    @Column(columnDefinition =  "VARCHAR(50)")
    private String componenthtml;

    @Column(columnDefinition = "VARCHAR(50)")
    private String componentcss;

    @Column(columnDefinition = "VARCHAR(50)")
    private String chaper_number;

    @Column(columnDefinition = "VARCHAR(50)")
    private String chaper_title;

    @ManyToOne
    @JoinColumn(name = "surveys")
    private Surveys surveys; 

    @ManyToMany(mappedBy = "chapters", cascade = CascadeType.ALL)
    private List<Questions> questions;
    
    

    public Surveys getSurveys() {
        return surveys;
    }

    public void setSurveys(Surveys surveys) {
        this.surveys = surveys;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public Chapters() {
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

    public String getComponenthtml() {
        return componenthtml;
    }

    public void setComponenthtml(String componenthtml) {
        this.componenthtml = componenthtml;
    }

    public String getComponentcss() {
        return componentcss;
    }

    public void setComponentcss(String componentcss) {
        this.componentcss = componentcss;
    }

    public String getChaper_number() {
        return chaper_number;
    }

    public void setChaper_number(String chaper_number) {
        this.chaper_number = chaper_number;
    }

    public String getChaper_title() {
        return chaper_title;
    }

    public void setChaper_title(String chaper_title) {
        this.chaper_title = chaper_title;
    }

    

    
}
