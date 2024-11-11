package com.fsse2410.BBB02_.exception.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CourseExistedException extends RuntimeException {
    public CourseExistedException(String courseId) {
        super("CourseExisted: " + courseId);
    }
}
