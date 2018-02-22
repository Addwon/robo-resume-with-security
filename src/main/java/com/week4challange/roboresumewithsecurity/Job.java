package com.week4challange.roboresumewithsecurity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
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
    private String requiredExperience;

    @NotNull
    @Size(min=10)
    private String jobDescription;

    @ManyToMany(mappedBy = "org")
    private List<Organization> jobs;

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

    public List<Organization> getJobs() {
        return jobs;
    }

    public void setJobs(List<Organization> jobs) {
        this.jobs = jobs;
    }
}
