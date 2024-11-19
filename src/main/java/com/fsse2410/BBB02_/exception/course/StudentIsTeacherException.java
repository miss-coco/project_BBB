package com.fsse2410.BBB02_.exception.course;

public class StudentIsTeacherException extends RuntimeException {
  public StudentIsTeacherException(String personHkid) {
    super("Student is Teacher: "+ personHkid);
  }
}
