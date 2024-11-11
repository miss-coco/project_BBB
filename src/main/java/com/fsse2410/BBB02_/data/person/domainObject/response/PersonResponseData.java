package com.fsse2410.BBB02_.data.person.domainObject.response;

import com.fsse2410.BBB02_.data.person.entity.PersonEntity;

public class PersonResponseData {
    private String firstName;
    private String lastName;
    private String hkid;

    public PersonResponseData(PersonEntity ty){
        this.firstName = ty.getFirstName();
        this.lastName = ty.getLastName();
        this.hkid = ty.getHkid();
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
