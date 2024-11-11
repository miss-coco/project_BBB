package com.fsse2410.BBB02_.data.person.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2410.BBB02_.data.person.domainObject.response.CreatePersonResponseData;

public class CreatePersonResponseDto {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("hkid_number")
    private String hkid;

    public CreatePersonResponseDto(CreatePersonResponseData a) {
        this.firstName = a.getFirstName();
        this.lastName = a.getLastName();
        this.hkid = a.getHkid();
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
