package com.fsse2410.BBB02_.service;

import com.fsse2410.BBB02_.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2410.BBB02_.data.course.domainObject.request.UpdateCourseRequestData;
import com.fsse2410.BBB02_.data.course.domainObject.response.CourseResponseData;
import com.fsse2410.BBB02_.data.course.entity.CourseEntity;
import com.fsse2410.BBB02_.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2410.BBB02_.data.person.domainObject.response.PersonResponseData;

import java.util.List;

public interface CourseService {
    CourseResponseData createCourse(CreateCourseRequestData createCourseRequestData);

    List<PersonResponseData> addStudentByPersonHkid(CreateCourseRequestData createCourseRequestData, String hkid);

    List<PersonResponseData> addStudentByPersonHkid(String hkid);

    List<PersonResponseData> addStudentByPersonHkid(CreatePersonRequestData createPersonRequestData, String hkid);

    List<CourseResponseData> getAllCourse();

    CourseResponseData updateCourse(UpdateCourseRequestData updateCourseRequestData);

    CourseResponseData deleteCourse(String courseId);

}
