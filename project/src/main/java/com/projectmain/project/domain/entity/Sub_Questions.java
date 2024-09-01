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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Sub_Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    Audit audit = new Audit();

    @Column(columnDefinition = "TEXT")
    private String subquestiontext;

    @ManyToOne
    @JoinColumn(name = "subquestion_id")
    private Questions questions;

    @OneToMany(mappedBy = "sub_Questions", cascade = CascadeType.ALL)
    private List<Option_Questions> option_Questions;

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

    public String getSubquestiontext() {
        return subquestiontext;
    }

    public void setSubquestiontext(String subquestiontext) {
        this.subquestiontext = subquestiontext;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public List<Option_Questions> getOption_Questions() {
        return option_Questions;
    }

    public void setOption_Questions(List<Option_Questions> option_Questions) {
        this.option_Questions = option_Questions;
    }
    
}
