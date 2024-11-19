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


    List<CourseResponseData> getAllPerson();

    CourseResponseData updateCourse(UpdateCourseRequestData updateCourseRequestData);

    CourseResponseData deleteCourse(String courseId);

    //checking : 有無呢個course, 有無呢個student
    CourseResponseData addStudent(String courseId, String personHkid);

    CourseResponseData deleteStudent(String courseId, String studentHkid);
}
//check 呢個list有無呢個學生

