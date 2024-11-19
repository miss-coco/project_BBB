package com.fsse2410.BBB02_.exception.course;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String personHkid) {
        super("Student Not Found: " + personHkid);
    }
}
