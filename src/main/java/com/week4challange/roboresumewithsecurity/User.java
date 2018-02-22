package com.week4challange.roboresumewithsecurity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="email",nullable=false)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="enabled")
    private boolean enabled;

    @Column(name="username")
    private String username;

    @Column(name="image")
    private String imgUrl;

//    private byte[] image;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(joinColumns=@JoinColumn(name = "user_id"),
    inverseJoinColumns=@JoinColumn(name="role_id"))
    private Collection<Role> roles;

    @ManyToMany
    @JoinTable(joinColumns=@JoinColumn(name = "user_id"),
            inverseJoinColumns=@JoinColumn(name="education_id"))
    private List<Education> usredu;

    @ManyToMany
    @JoinTable(joinColumns=@JoinColumn(name = "user_id"),
            inverseJoinColumns=@JoinColumn(name="experience_id"))
    private List<Experience> usrexp;

    @ManyToMany
    @JoinTable(joinColumns=@JoinColumn(name = "user_id"),
            inverseJoinColumns=@JoinColumn(name="skill_id"))
    private List<Skill> usrskill;

    public User(String email, String password, String firstName, String lastName, boolean enabled, String username,String imgUrl) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.username = username;
        this.imgUrl=imgUrl;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }
}

