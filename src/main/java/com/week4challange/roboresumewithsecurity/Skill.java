package com.week4challange.roboresumewithsecurity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

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

//    @ManyToMany(mappedBy = "usrskill", cascade = CascadeType.ALL)
    @ManyToMany(mappedBy = "usrskill")
    private List<User> skills;

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

    public List<User> getSkills() {
        return skills;
    }

    public void setSkills(List<User> skills) {
        this.skills = skills;
    }
}
