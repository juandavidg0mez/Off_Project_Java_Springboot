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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    Audit audit = new Audit();

    @Column(columnDefinition = "VARCHAR(10)")
    private String question_number;

    @Column(columnDefinition = "VARCHAR(10)")
    private String response_type;

    @Column(columnDefinition = "TEXT")
    private String commet_question;

    @Column(columnDefinition = "TEXT")
    private String question_text;

    @ManyToMany
    @JoinTable(
        name = "question_chapters",
        joinColumns = @JoinColumn(name = "chapter_id"),
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Chapters> chapters;

    @OneToMany(mappedBy = "questions", cascade = CascadeType.ALL)
    private List<Question_Categories> question_Categories;

    @OneToMany(mappedBy = "questions", cascade = CascadeType.ALL)
    private List<Sub_Questions> sub_Questions;

    @OneToMany(mappedBy = "questions", cascade = CascadeType.ALL)
    private List<Option_Questions> option_Questions;

    

    public Questions() {
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



    public String getQuestion_number() {
        return question_number;
    }



    public void setQuestion_number(String question_number) {
        this.question_number = question_number;
    }



    public String getResponse_type() {
        return response_type;
    }



    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }



    public String getCommet_question() {
        return commet_question;
    }



    public void setCommet_question(String commet_question) {
        this.commet_question = commet_question;
    }



    public String getQuestion_text() {
        return question_text;
    }



    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }



    public List<Chapters> getChapters() {
        return chapters;
    }



    public void setChapters(List<Chapters> chapters) {
        this.chapters = chapters;
    }



    public List<Question_Categories> getQuestion_Categories() {
        return question_Categories;
    }



    public void setQuestion_Categories(List<Question_Categories> question_Categories) {
        this.question_Categories = question_Categories;
    }



    public List<Sub_Questions> getSub_Questions() {
        return sub_Questions;
    }



    public void setSub_Questions(List<Sub_Questions> sub_Questions) {
        this.sub_Questions = sub_Questions;
    }



    public List<Option_Questions> getOption_Questions() {
        return option_Questions;
    }



    public void setOption_Questions(List<Option_Questions> option_Questions) {
        this.option_Questions = option_Questions;
    }

    
    
    

    
}
