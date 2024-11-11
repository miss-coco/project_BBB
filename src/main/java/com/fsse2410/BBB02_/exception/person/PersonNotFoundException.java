package com.fsse2410.BBB02_.exception.person;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String hkid) {
        super("Person Not Found: " + hkid);
    }
}
