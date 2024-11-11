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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course") //打左呢句，以下mapping後面都不用再加野
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
    public List<CourseResponseDto> getAllCourse() {
        List<CourseResponseData> courseResponseDataList = courseService.getAllCourse();
        List<CourseResponseDto> courseResponseDtoList = new ArrayList<>();
        for (CourseResponseData courseResponseData : courseResponseDataList) {
            CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        }
        return courseResponseDtoList;
    }

    @PutMapping
    public CourseResponseDto updateCourse(@RequestBody UpdateCourseRequestDto updateCourseRequestDto) {
        UpdateCourseRequestData updateCourseRequestData = new UpdateCourseRequestData(updateCourseRequestDto);
        CourseResponseData courseResponseData = courseService.updateCourse(updateCourseRequestData);
        CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        return courseResponseDto;
    }

    @DeleteMapping
    public CourseResponseDto deleteCourse(@RequestParam String courseId) {
        CourseResponseData courseResponseData = courseService.deleteCourse(courseId);
        CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        return courseResponseDto;
    }

    @PatchMapping
    public List<CourseResponseDto> addStudentByPersonHkid(String courseId, String hkid) {
        List<CourseResponseData> courseResponseDataList = courseService.getAllCourse();
        List<CourseResponseDto> courseResponseDtoList = new ArrayList<>();
        for (CourseResponseData courseResponseData : courseResponseDataList) {
            CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
            courseResponseDtoList.add(courseResponseDto);
        }
        return courseResponseDtoList;
    }
}
