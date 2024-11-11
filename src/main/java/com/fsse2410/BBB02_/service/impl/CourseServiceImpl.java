package com.fsse2410.BBB02_.service.impl;

import com.fsse2410.BBB02_.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2410.BBB02_.data.course.domainObject.request.UpdateCourseRequestData;
import com.fsse2410.BBB02_.data.course.domainObject.response.CourseResponseData;
import com.fsse2410.BBB02_.data.course.entity.CourseEntity;
import com.fsse2410.BBB02_.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2410.BBB02_.data.person.domainObject.response.PersonResponseData;
import com.fsse2410.BBB02_.data.person.entity.PersonEntity;
import com.fsse2410.BBB02_.exception.course.CourseExistedException;
import com.fsse2410.BBB02_.exception.course.CourseNotFoundException;
import com.fsse2410.BBB02_.exception.person.PersonNotFoundException;
import com.fsse2410.BBB02_.service.CourseService;
import com.fsse2410.BBB02_.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private List<CourseEntity> courseEntityList = new ArrayList<>();
    private List<PersonEntity> personEntityList = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    //用autowired/ dependency
    private final PersonService personService;

    @Autowired
    public CourseServiceImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public CourseResponseData createCourse(CreateCourseRequestData createCourseRequestData) {
        try {
            if (isExistedByCourseId(createCourseRequestData.getCourseId())) { //method check id 時,id是在createCourseRequestData拎的
                throw new CourseExistedException(createCourseRequestData.getCourseId());
            }//拎requestData的getteacherid對下老師的teacher id是否一樣,是personNotFoundException

            PersonEntity teacherEntity = personService.getEntityByHkid(createCourseRequestData.getTeacherHkid());
            CourseEntity newCourseEntity = new CourseEntity(createCourseRequestData, teacherEntity);
            courseEntityList.add(newCourseEntity);
            CourseResponseData courseResponseData = new CourseResponseData(newCourseEntity);
            return courseResponseData;
        } catch (Exception ex) {
            logger.warn("Create Course Failed: " + ex.getMessage());
            throw ex;
        }
//        catch (CourseExistedException ex){
//            logger.warn("Create Course Failed: " + ex.getMessage());
//            throw ex;
//        }catch (PersonNotFoundException ex) {
//            logger.warn("Create Course Found Teacher Failed: " + ex.getMessage());
//            throw ex;
    }

    @Override
    public List<PersonResponseData> addStudentByPersonHkid(CreateCourseRequestData createCourseRequestData, String hkid) {
        return List.of();
    }

    @Override
    public List<PersonResponseData> addStudentByPersonHkid(String hkid) {
        return List.of();
    }

    @Override
    public List<PersonResponseData> addStudentByPersonHkid(CreatePersonRequestData createPersonRequestData, String hkid) {
        try {
            List<PersonResponseData> courseResponseDataList = new ArrayList<>();
            for (PersonEntity personEntity : personEntityList) {
                if (!personEntity.getHkid().equals(hkid)) {
                    continue;
                }
                PersonResponseData personResponseData = new PersonResponseData(personEntity);
                courseResponseDataList.add(personResponseData);
            }
            return courseResponseDataList;
        } catch (Exception ex) {
            logger.warn("Person Hkid Existed: " + ex.getMessage());
            throw ex;
        }
    }
    @Override
    public List<CourseResponseData> getAllCourse(){
        List<CourseResponseData> courseResponseDataList = new ArrayList<>();
        for (CourseEntity courseEntity : courseEntityList){
            CourseResponseData courseResponseData = new CourseResponseData(courseEntity);
            courseResponseDataList.add(courseResponseData);
        }
        return courseResponseDataList;
    }
    @Override
    public CourseResponseData updateCourse(UpdateCourseRequestData updateCourseRequestData) {
        try {
            for (CourseEntity courseEntity : courseEntityList) {
                if (courseEntity.getCourseId().equals(updateCourseRequestData.getCourseId())) {
                    courseEntity.setPrice(updateCourseRequestData.getPrice());
                    courseEntity.setCourseName(updateCourseRequestData.getCourseName());
                    CourseResponseData courseResponseData = new CourseResponseData(courseEntity);
                    return courseResponseData;
                }
            }
            throw new PersonNotFoundException(updateCourseRequestData.getCourseId());
        } catch (Exception ex) {
            logger.warn("Update Course Failed: " + ex.getMessage());
            throw ex;
        }
    }
    @Override
    public CourseResponseData deleteCourse(String courseId) {
        try {
            CourseEntity deleteCourse = getEntityByCourseId(courseId);
            courseEntityList.remove(deleteCourse);
            return new CourseResponseData(deleteCourse);
        } catch (Exception ex) {
            logger.warn("Delete Course Failed: " + ex.getMessage());
            throw ex;
        }
    }
   

    public boolean existedByHkidd(String hkid){
        for (PersonEntity personEntity : personEntityList){
            if (personEntity.getHkid().equals(hkid)){
                return true;
            }
        }
        return false;
    }

    public boolean isExistedByCourseId(String courseId){
        for (CourseEntity courseEntity : courseEntityList){
            if (courseEntity.getCourseId().equals(courseId)){
                return true;
            }
        }
        return false;
    }
    public CourseEntity getEntityByCourseId(String courseId){
        for (CourseEntity courseEntity : courseEntityList){
            if (courseEntity.getCourseId().equalsIgnoreCase(courseId)){
                return courseEntity;
            }
        }
        throw new CourseNotFoundException(courseId);
    }
}
