package com.fsse2410.BBB02_.exception.course;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String courseId) {
        super("Course Not Found: " + courseId);
    }
}
