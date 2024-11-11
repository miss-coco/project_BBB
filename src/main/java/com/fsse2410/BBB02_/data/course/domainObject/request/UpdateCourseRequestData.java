package com.fsse2410.BBB02_.data.course.domainObject.request;

import com.fsse2410.BBB02_.data.course.dto.request.UpdateCourseRequestDto;

import java.math.BigDecimal;

public class UpdateCourseRequestData {
    private String courseId;
    private String courseName;
    private BigDecimal price;
    private String teacherHkid;

    public UpdateCourseRequestData(UpdateCourseRequestDto to){
        this.courseId = to.getCourseId();
        this.courseName = to.getCourseName();
        this.price = to.getPrice();
        this.teacherHkid = to.getTeacherHkid();
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

    public String getTeacherHkid() {
        return teacherHkid;
    }

    public void setTeacherHkid(String teacherHkid) {
        this.teacherHkid = teacherHkid;
    }
}
