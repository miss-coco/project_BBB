package com.fsse2410.BBB02_.exception.course;

public class PersonHkidNotFoundException extends RuntimeException {
    public PersonHkidNotFoundException(String personHkid) {
        super("Person Hkid Not Found: " + personHkid);
    }
}
