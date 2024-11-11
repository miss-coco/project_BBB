package com.fsse2410.BBB02_.data.person.domainObject.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2410.BBB02_.data.person.dto.request.CreatePersonRequestDto;

public class CreatePersonRequestData {
    private String firstName;
    private String lastName;
    private String hkid;

    public CreatePersonRequestData(CreatePersonRequestDto to) {
        this.firstName = to.getFirstName();
        this.lastName = to.getLastName();
        this.hkid = to.getHkid();
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
