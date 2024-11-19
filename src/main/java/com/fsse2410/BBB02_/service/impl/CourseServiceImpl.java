package com.fsse2410.BBB02_.service.impl;

import com.fsse2410.BBB02_.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2410.BBB02_.data.course.domainObject.request.UpdateCourseRequestData;
import com.fsse2410.BBB02_.data.course.domainObject.response.CourseResponseData;
import com.fsse2410.BBB02_.data.course.entity.CourseEntity;
import com.fsse2410.BBB02_.data.person.entity.PersonEntity;
import com.fsse2410.BBB02_.exception.course.*;
import com.fsse2410.BBB02_.repository.CourseRepository;
import com.fsse2410.BBB02_.service.CourseService;
import com.fsse2410.BBB02_.service.PersonService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private List<CourseEntity> courseEntityList = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    //用autowired/ dependency
    private final PersonService personService;

    private final CourseRepository courseRepository;
    @Autowired
    public CourseServiceImpl(PersonService personService, CourseRepository courseRepository) {
        this.personService = personService;
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseResponseData createCourse(CreateCourseRequestData createCourseRequestData) {
        try {
            if (isExistedByCourseId(createCourseRequestData.getCourseId())) { //method check id 時,id是在createCourseRequestData拎的
                throw new CourseExistedException(createCourseRequestData.getCourseId());
            }//拎requestData的getteacherid對下老師的teacher id是否一樣,是personNotFoundException
//              Lv2
//            PersonEntity teacherEntity = personService.getEntityByHkid(createCourseRequestData.getTeacherHkid());
//            CourseEntity newCourseEntity = new CourseEntity(createCourseRequestData, teacherEntity);
//            courseEntityList.add(newCourseEntity);
//            CourseResponseData courseResponseData = new CourseResponseData(newCourseEntity);
//            return courseResponseData;

//            Lv3
            CourseEntity newCourseEntity = new CourseEntity(
                    createCourseRequestData, personService.getEntityByHkid(
                    createCourseRequestData.getTeacherHkid())
            );
            newCourseEntity = courseRepository.save(newCourseEntity);
            return new CourseResponseData(newCourseEntity);
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
    public List<CourseResponseData> getAllPerson() {
        List<CourseResponseData> courseResponseDataList = new ArrayList<>();
        for (CourseEntity courseEntity : courseRepository.findAll()) {
            CourseResponseData courseResponseData = new CourseResponseData(courseEntity);
            courseResponseDataList.add(courseResponseData);
        }
        return courseResponseDataList;
    }

    @Override
    public CourseResponseData updateCourse(UpdateCourseRequestData updateCourseRequestData) {
        try {
//            Lv2
//            CourseEntity courseEntity = getEntityByCourseId(updateCourseRequestData.getCourseId());
//
//            //拎返老師，才能做line 78
//            PersonEntity teacher = personService.getEntityByHkid(updateCourseRequestData.getTeacherHkid());
//            courseEntity.setCourseName(updateCourseRequestData.getCourseName());
//            courseEntity.setPrice(updateCourseRequestData.getPrice());
//            courseEntity.setTeacher(teacher);
//            CourseResponseData courseResponseData = new CourseResponseData(courseEntity);
//            return courseResponseData;

//            Lv3
            CourseEntity courseEntity = getEntityByCourseId(updateCourseRequestData.getCourseId());
            courseEntity.setCourseName(updateCourseRequestData.getCourseName());
            courseEntity.setPrice(updateCourseRequestData.getPrice());
            courseEntity.setTeacher(personService.getEntityByHkid(updateCourseRequestData.getTeacherHkid()));


            return new CourseResponseData(
                    courseRepository.save(courseEntity)
            );

        } catch (Exception ex) {
            logger.warn("Update Course Failed: " + ex.getMessage());
            throw ex;
        }
    }

    @Override
    @Transactional
    public CourseResponseData deleteCourse(String courseId) {
        try {
            CourseEntity courseEntity = getEntityByCourseId(courseId);
            courseRepository.delete(courseEntity);
            return new CourseResponseData(courseEntity);
        } catch (Exception ex) {
            logger.warn("Delete Course Failed: " + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public CourseResponseData addStudent(String courseId, String studentHkid) {
        try {
            CourseEntity courseEntity = getEntityByCourseId(courseId); //拎左courseEntity和personEntity返來
            PersonEntity studentEntity = personService.getEntityByHkid(studentHkid);
//            //checking course 老師不會是student
            if (courseEntity.getTeacher().getHkid().equals(studentHkid)) {
                throw new StudentIsTeacherException(studentHkid);
            }
            List<PersonEntity> studentList = courseEntity.getStudents(); //在courseEntity度拎個studentList出來
            for (PersonEntity student : studentList) {
                if (student.getHkid().equals(studentHkid)) {//check學生是否宱左個course
                    throw new StudentExistedException(studentHkid);
                }
            }
            studentList.add(studentEntity);

//            courseEntity.setStudents(studentList);
//            return new CourseResponseData(courseEntity);
            return new CourseResponseData(
                    courseRepository.save(courseEntity)
            );

        } catch (Exception ex) {
            logger.warn("Add Student: " + ex.getMessage());
            throw ex;
        }
}

    @Override
    @Transactional
    public CourseResponseData deleteStudent(String courseId, String studentHkid) {
        try {
            CourseEntity courseEntity = getEntityByCourseId(courseId);
            CourseResponseData courseResponseData = new CourseResponseData(courseEntity);
            courseRepository.delete(courseEntity);

                return new CourseResponseData(courseEntity);

        } catch (Exception ex) {
            logger.warn("Remove Student: " + ex.getMessage());
            throw ex;
        }
    }

    public boolean isExistedByCourseId(String courseId) {
        return courseRepository.existsById(courseId);
    }

    public CourseEntity getEntityByCourseId(String courseId) {
//        Lv2
//        Optional<CourseEntity> optionalCourseEntity = courseRepository.findById(courseId);
//        if (optionalCourseEntity.isEmpty()) {
//            throw new CourseNotFoundException(courseId);
//        }
//        return optionalCourseEntity.get();

//        Lv3
        return courseRepository.findById(courseId).orElseThrow(
                () -> new CourseNotFoundException(courseId)
        );
    }
}