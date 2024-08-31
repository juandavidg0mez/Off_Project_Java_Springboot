package com.projectmain.project.domain.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    Audit audit = new Audit();

    @Column(columnDefinition = "VARCHAR(50)")
    private String optiontext;

    @OneToMany(mappedBy = "options" , cascade =  CascadeType.ALL)
    private List<category_options> Category_Options;

    public Options() {
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

    public String getOptiontext() {
        return optiontext;
    }

    public void setOptiontext(String optiontext) {
        this.optiontext = optiontext;
    }

    public List<category_options> getCategory_Options() {
        return Category_Options;
    }

    public void setCategory_Options(List<category_options> category_Options) {
        Category_Options = category_Options;
    }

    
    
    
    


}
