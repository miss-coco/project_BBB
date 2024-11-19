package com.fsse2410.BBB02_.data.course.entity;

import com.fsse2410.BBB02_.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2410.BBB02_.data.person.entity.PersonEntity;
import com.fsse2410.BBB02_.service.PersonService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
public class CourseEntity {
    @Id
    @Column(nullable = false) //@NotEmpty係extra checking, nullable=false是一定要有,會影響table
    private String courseId;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "teacher_pid", referencedColumnName = "pid", nullable = false)
    private PersonEntity teacher; //teacherhkid is Object type PersonEntity

    //(cascade = CascadeType.ALL) CascadeType.ALL: 當有關係的時候，會冚家富貴,一delete就全部delete
    @ManyToMany(fetch = FetchType.EAGER) //
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "course_pid"), //自己table的primary key
            inverseJoinColumns = @JoinColumn(name = "student_pid")//對面table的primary key
    )
    private List<PersonEntity> students = new ArrayList<>(); //以防有nullpoint直接放埋個arraylist入去
    //follow the question:create course (without assigning students)

    public CourseEntity(CreateCourseRequestData ta, PersonEntity teacher) {//requestData只有teacherId不是id list,所以要整左teacherEntity才能整呢個constructor
        this.courseId = ta.getCourseId();
        this.courseName = ta.getCourseName();
        this.price = ta.getPrice();
        this.teacher = teacher; //呢度只能收個teacher返來
    }

    public CourseEntity() { //hibernate 需要
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

    public PersonEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(PersonEntity teacher) {
        this.teacher = teacher;
    }

    public List<PersonEntity> getStudents() {
        return students;
    }

    public void setStudents(List<PersonEntity> students) {
        this.students = students;
    }
}
