package com.week4challange.roboresumewithsecurity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=2)
    private String major;

    @NotNull
    @Size(min=2)
    private String school;

    @NotNull
    private int gradYear;

    @ManyToMany(mappedBy = "usredu")
    private List<User> educations;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public List<User> getEducations() {
        return educations;
    }

    public void setEducations(List<User> educations) {
        this.educations = educations;
    }
}
