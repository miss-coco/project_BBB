package com.fsse2410.BBB02_.data.person.domainObject.request;

import com.fsse2410.BBB02_.data.person.dto.request.CreatePersonRequestDto;
import com.fsse2410.BBB02_.data.person.dto.request.UpdatePersonRequestDto;

public class UpdatePersonRequestData {
    private String firstName;
    private String lastName;
    private String hkid;

    public UpdatePersonRequestData(UpdatePersonRequestDto c){
        this.firstName = c.getFirstName();
        this.lastName = c.getLastName();
        this.hkid = c.getHkid();
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
