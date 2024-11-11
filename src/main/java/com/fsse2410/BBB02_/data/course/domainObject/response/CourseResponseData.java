package com.fsse2410.BBB02_.data.course.domainObject.response;

import com.fsse2410.BBB02_.data.course.entity.CourseEntity;
import com.fsse2410.BBB02_.data.person.domainObject.response.PersonResponseData;
import com.fsse2410.BBB02_.data.person.entity.PersonEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CourseResponseData {
    private String courseId;
    private String courseName;
    private BigDecimal price;
    private PersonResponseData teacher;
    private List<PersonResponseData> students = new ArrayList<>();



    public CourseResponseData(CourseEntity courseEntity) {
        this.courseId = courseEntity.getCourseId();
        this.courseName = courseEntity.getCourseName();
        this.price = courseEntity.getPrice();
        this.teacher = new PersonResponseData(courseEntity.getTeacher()); //line 15
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PersonResponseData getTeacher() {
        return teacher;
    }

    public void setTeacher(PersonResponseData teacher) {
        this.teacher = teacher;
    }

    public List<PersonResponseData> getStudents() {
        return students;
    }

    public void setStudents(List<PersonResponseData> students) {
        this.students = students;
    }
}
