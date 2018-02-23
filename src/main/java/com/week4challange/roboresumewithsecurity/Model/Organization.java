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
//
//    @ManyToMany()
//    private Set<Job> ownerorgn;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Job> jobs;

//    @ManyToMany(mappedBy="jobs")
//    private Set<Job> jobs;

//    public Organization(){
//        this.ownerorgn=new HashSet<Job>();
//    }

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

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }


//    public Set<Job> getOwnerorgn() {
//        return ownerorgn;
//    }
//
//    public void setOwnerorgn(Set<Job> ownerorgn) {
//        this.ownerorgn = ownerorgn;
//    }
}
