package com.projectmain.project.domain.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Option_Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    Audit audit = new Audit();

    @ManyToOne
    @JoinColumn(name = "subquestion_id")
    private Sub_Questions sub_Questions;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Options options;

    @ManyToOne
    @JoinColumn(name = "optionquestion_id")
    private Questions questions;

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

    public Sub_Questions getSub_Questions() {
        return sub_Questions;
    }

    public void setSub_Questions(Sub_Questions sub_Questions) {
        this.sub_Questions = sub_Questions;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    

}
