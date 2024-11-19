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


    public CourseResponseData(CourseEntity entity) {
        this.courseId = entity.getCourseId();
        this.courseName = entity.getCourseName();
        this.price = entity.getPrice();
        this.teacher = new PersonResponseData(entity.getTeacher()); //line 15
        setStudents(entity);
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

    //呢個setter最好不要del, 因為係比library自己用
    public void setStudents(List<PersonResponseData> students) {
        this.students = students;
    }

    public void setStudents(CourseEntity courseEntity) {
        for (PersonEntity student : courseEntity.getStudents()) {
//        Lv2
//        PersonResponseData personResponseData = new PersonResponseData(student);
//        students.add(personResponseData);
//        Lv3
            students.add(new PersonResponseData(student));
        }
    }
}
