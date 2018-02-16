package com.week4challange.roboresumewithsecurity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=2)
    private String referenceFirstName;

    @NotNull
    @Size(min=2)
    private String referenceLastName;

    @NotNull
    @Size(min=2)
    private String referenceJobPosition;

    @NotNull
    @Size(min=2)
    private String referenceCompany;

    @NotNull
    @Size(min=5)
    private String referenceAddress;

    @NotNull
    @Size(min=2)
    private String referenceCity;

    @NotNull
    @Min(10)
    private long referencePhone;

    @NotNull
    @Email
    private String referenceEmail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReferenceFirstName() {
        return referenceFirstName;
    }

    public void setReferenceFirstName(String referenceFirstName) {
        this.referenceFirstName = referenceFirstName;
    }

    public String getReferenceLastName() {
        return referenceLastName;
    }

    public void setReferenceLastName(String referenceLastName) {
        this.referenceLastName = referenceLastName;
    }

    public String getReferenceJobPosition() {
        return referenceJobPosition;
    }

    public void setReferenceJobPosition(String referenceJobPosition) {
        this.referenceJobPosition = referenceJobPosition;
    }

    public String getReferenceCompany() {
        return referenceCompany;
    }

    public void setReferenceCompany(String referenceCompany) {
        this.referenceCompany = referenceCompany;
    }

    public String getReferenceAddress() {
        return referenceAddress;
    }

    public void setReferenceAddress(String referenceAddress) {
        this.referenceAddress = referenceAddress;
    }

    public String getReferenceCity() {
        return referenceCity;
    }

    public void setReferenceCity(String referenceCity) {
        this.referenceCity = referenceCity;
    }

    public long getReferencePhone() {
        return referencePhone;
    }

    public void setReferencePhone(long referencePhone) {
        this.referencePhone = referencePhone;
    }

    public String getReferenceEmail() {
        return referenceEmail;
    }

    public void setReferenceEmail(String referenceEmail) {
        this.referenceEmail = referenceEmail;
    }
}
