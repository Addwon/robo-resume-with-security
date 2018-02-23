package com.week4challange.roboresumewithsecurity.Model;

import com.week4challange.roboresumewithsecurity.Model.Job;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=2)
    private String organizationName;

    @NotNull
    @Size(min=5)
    private String organizationAddress;

    @OneToMany(mappedBy = "organization")
    private Set<Job> jobPostSet = new HashSet<>();

//    @ManyToMany
//    private List<Job> org;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public Set<Job> getJobPostSet() {
        return jobPostSet;
    }

    public void setJobPostSet(Set<Job> jobPostSet) {
        this.jobPostSet = jobPostSet;
    }

//    public List<Job> getOrg() {
//        return org;
//    }
//
//    public void setOrg(List<Job> org) {
//        this.org = org;
//    }
}
