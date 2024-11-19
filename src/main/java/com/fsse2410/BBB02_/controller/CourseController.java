package com.fsse2410.BBB02_.controller;

import com.fsse2410.BBB02_.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2410.BBB02_.data.course.domainObject.request.UpdateCourseRequestData;
import com.fsse2410.BBB02_.data.course.domainObject.response.CourseResponseData;
import com.fsse2410.BBB02_.data.course.dto.request.CreateCourseRequestDto;
import com.fsse2410.BBB02_.data.course.dto.request.UpdateCourseRequestDto;
import com.fsse2410.BBB02_.data.course.dto.response.CourseResponseDto;
import com.fsse2410.BBB02_.data.course.entity.CourseEntity;
import com.fsse2410.BBB02_.data.person.domainObject.response.PersonResponseData;
import com.fsse2410.BBB02_.data.person.dto.response.PersonResponseDto;
import com.fsse2410.BBB02_.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course") //打左呢句，以下mapping後面都不用再加野
@Validated
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseResponseDto createCourse(@Valid @RequestBody CreateCourseRequestDto createCourseRequestDto) {
        CreateCourseRequestData createCourseRequestData = new CreateCourseRequestData(createCourseRequestDto);
        CourseResponseData courseResponseData = courseService.createCourse(createCourseRequestData);
        CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        return courseResponseDto;
    }

    @GetMapping
    public List<CourseResponseDto> getAllPerson(){
        List<CourseResponseDto> courseResponseDtoList = new ArrayList<>();
        List<CourseResponseData> courseResponseDataList = courseService.getAllPerson();
        for (CourseResponseData courseResponseData : courseResponseDataList){
            CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
            courseResponseDtoList.add(courseResponseDto);
        }
        return courseResponseDtoList;
    }

    @PutMapping
    public CourseResponseDto updateCourse(@Valid @RequestBody UpdateCourseRequestDto updateCourseRequestDto) {
        UpdateCourseRequestData updateCourseRequestData = new UpdateCourseRequestData(updateCourseRequestDto);
        CourseResponseData courseResponseData = courseService.updateCourse(updateCourseRequestData);
        CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        return courseResponseDto;
    }

    @DeleteMapping("/{courseId}")
    public CourseResponseDto deleteCourse(@PathVariable("courseId") String courseId) { //題目指定要用pathvariable:("/courseId")
        CourseResponseData courseResponseData = courseService.deleteCourse(courseId);
        CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        return courseResponseDto;
    }

    @PatchMapping("/{courseId}/add-student/{studentHkid}") //("/{courseId}/student/add/")
    public CourseResponseDto addStudent(@Pattern(regexp = "FSSE\\d{4}") @PathVariable String courseId,
                                        @Pattern(regexp = "[A-Z]\\d{6}\\(([1-9]|A)\\)") @PathVariable String studentHkid){
        CourseResponseData courseResponseData = courseService.addStudent(courseId, studentHkid);
        CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        return courseResponseDto;
    }
    @PatchMapping("/{courseId}/remove-student/{studentHkid}") //("/{courseId}/student/add/")
    public CourseResponseDto removeStudent(@Pattern(regexp = "FSSE\\d{4}") @PathVariable String courseId,
                                           @Pattern(regexp = "[A-Z]\\d{6}\\(([1-9]|A)\\)") @PathVariable String studentHkid){
        CourseResponseData courseResponseData = courseService.deleteStudent(courseId, studentHkid);
        CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        return courseResponseDto;
    }

}
