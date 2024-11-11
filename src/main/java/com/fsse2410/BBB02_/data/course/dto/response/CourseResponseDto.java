package com.fsse2410.BBB02_.data.course.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2410.BBB02_.data.course.domainObject.response.CourseResponseData;
import com.fsse2410.BBB02_.data.person.dto.response.PersonResponseDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CourseResponseDto {

    @JsonProperty("course_id")
    private String courseId;

    @JsonProperty("course_name")
    private String courseName;

    private BigDecimal price;

    private PersonResponseDto teacher;
    private List<PersonResponseDto> students = new ArrayList<>();

    public CourseResponseDto(CourseResponseData ta){
        this.courseId = ta.getCourseId();
        this.courseName = ta.getCourseName();
        this.price = ta.getPrice();
        this.teacher = new PersonResponseDto(ta.getTeacher()); //由data 轉去dto
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

    public PersonResponseDto getTeacher() {
        return teacher;
    }

    public void setTeacher(PersonResponseDto teacher) {
        this.teacher = teacher;
    }

    public List<PersonResponseDto> getStudents() {
        return students;
    }

    public void setStudents(List<PersonResponseDto> students) {
        this.students = students;
    }
}
