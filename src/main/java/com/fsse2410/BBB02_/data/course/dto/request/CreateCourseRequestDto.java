package com.fsse2410.BBB02_.data.course.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public class CreateCourseRequestDto {

    @NotBlank
    @JsonProperty("course_id")
    private String courseId;

    @NotBlank
    @JsonProperty("course_name")
    private String courseName;

    @Min(60000)  //呢d pojo會掉去entity果邊,所以要用大階Double/Decimal(Object type)好處是可以null
    private BigDecimal price; //double 會多左0.000000111果d,用bigdecimal會好d

    @Pattern(regexp = "[A-Z]\\d{6}\\(([1-9]|A)\\)") //原只有一個＼,paste落呢度會變double \
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

    public @Min(60000) BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@Min(60000) BigDecimal price) {
        this.price = price;
    }

    public @Pattern(regexp = "[A-Z]\\d{6}\\(([1-9]|A)\\)") String getTeacherHkid() {
        return teacherHkid;
    }

    public void setTeacherHkid(@Pattern(regexp = "[A-Z]\\d{6}\\(([1-9]|A)\\)") String teacherHkid) {
        this.teacherHkid = teacherHkid;
    }
}