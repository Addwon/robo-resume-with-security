package com.week4challange.roboresumewithsecurity.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=2)
    private String jobTitle;

    @NotNull
    @Size(min=2)
    private String requiredSkill;

    @NotNull
    @Size(min=2)
    private String _orgnization;

    @NotNull
    @Size(min=2)
    private String requiredExperience;

    @NotNull
    @Size(min=10)
    private String jobDescription;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private Organization organization;

    @ManyToMany(mappedBy="requiredSkills")
    private Set<Skill> skills;

    @ManyToMany(mappedBy="ownerorgn")
    private Set<Organization> orgn;

    public Job(){
        skills=new HashSet<Skill>();
        orgn=new HashSet<Organization>();
    }

//    @ManyToMany(mappedBy = "org")
//    private List<Organization> jobs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public String getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(String requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }


    public Set<Organization> getOrgn() {
        return orgn;
    }

    public void setOrgn(Set<Organization> orgn) {
        this.orgn = orgn;
    }

    public String get_orgnization() {
        return _orgnization;
    }

    public void set_orgnization(String _orgnization) {
        this._orgnization = _orgnization;
    }
}
