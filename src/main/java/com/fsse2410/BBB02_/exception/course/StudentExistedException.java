package com.fsse2410.BBB02_.exception.course;

public class StudentExistedException extends RuntimeException {
    public StudentExistedException(String personHkid) {
        super("Student Existed: " + personHkid);
    }
}
