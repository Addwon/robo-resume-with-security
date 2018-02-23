package com.week4challange.roboresumewithsecurity.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=2)
    String type;

    @NotNull
    @Size(min=2)
    String skillLevel;



    public Set<Job> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(Set<Job> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }


    @ManyToMany()
    private Set<Job> requiredSkills;

//    @ManyToMany()
//    private Set<User> user;
//
    public Skill(){
         //this.user=new HashSet<User>();
        this.requiredSkills=new HashSet<Job>();
    }



//    @ManyToMany(fetch=FetchType.EAGER)
//    @JoinTable(joinColumns=@JoinColumn(name = "skill_id"),
//            inverseJoinColumns=@JoinColumn(name="user_id"))
//    private Collection<User> users;
//
//    @ManyToMany(mappedBy="skills",fetch=FetchType.LAZY)
//    private Collection<User> users;

//    @ManyToMany
//    private Set<User> user;
/*
//    @ManyToMany(mappedBy = "usrskill", cascade = CascadeType.ALL)
    @ManyToMany(mappedBy = "usrskill")
    private List<User> skills;
*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }


//    public Set<User> getUser() {
//        return user;
//    }
//
//    public void setUser(Set<User> user) {
//        this.user = user;
//    }
}
