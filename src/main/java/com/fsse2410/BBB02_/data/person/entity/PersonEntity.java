package com.fsse2410.BBB02_.data.person.entity;

import com.fsse2410.BBB02_.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2410.BBB02_.data.person.domainObject.response.CreatePersonResponseData;

public class PersonEntity {
    private String firstName;
    private String lastName;
    private String hkid;

    public PersonEntity(CreatePersonRequestData ta) {
        this.firstName = ta.getFirstName();
        this.lastName = ta.getLastName();
        this.hkid = ta.getHkid();
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

    public String getHkid() {
        return hkid;
    }

    public void setHkid(String hkid) {
        this.hkid = hkid;
    }
}
