package com.fsse2410.BBB02_.data.course.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public class UpdateCourseRequestDto {
    @NotBlank
    @JsonProperty("course_id")
    private String courseId;

    @NotBlank
    @JsonProperty("course_name")
    private String courseName;

    @Min(500)
    private BigDecimal price;

    @Pattern(regexp = "[A-Z]\\d{6}\\(([1-9]|A)\\)")
    @JsonProperty("teacher_hkid")
    private String teacherHkid;


    public @NotBlank String getCourseId() {
        return courseId;
    }

    public void setCourseId(@NotBlank String courseId) {
        this.courseId = courseId;
    }

    public @NotBlank String getCourseName() {
        return courseName;
    }

    public void setCourseName(@NotBlank String courseName) {
        this.courseName = courseName;
    }

    public @Min(500) BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@Min(500) BigDecimal price) {
        this.price = price;
    }

    public @Pattern(regexp = "[A-Z]\\d{6}\\(([1-9]|A)\\)") String getTeacherHkid() {
        return teacherHkid;
    }

    public void setTeacherHkid(@Pattern(regexp = "[A-Z]\\d{6}\\(([1-9]|A)\\)") String teacherHkid) {
        this.teacherHkid = teacherHkid;
    }
}
