package com.fsse2410.BBB02_.data.person.entity;

import com.fsse2410.BBB02_.data.course.entity.CourseEntity;
import com.fsse2410.BBB02_.data.person.domainObject.request.CreatePersonRequestData;
import com.fsse2410.BBB02_.data.person.domainObject.response.CreatePersonResponseData;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Column(name = "first_name", nullable = false) //用column可以改名
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "hkid", nullable = false, unique = true)
    private String hkid;

    @OneToMany(mappedBy = "teacher") //對應返另一個table 的entity name
    private List<CourseEntity> courseTeaching; //

    @ManyToMany(mappedBy = "students")
    private List<CourseEntity> courseAttending; //學生修幾多個course,整個list出來

    public PersonEntity(CreatePersonRequestData ta) {
        this.firstName = ta.getFirstName();
        this.lastName = ta.getLastName();
        this.hkid = ta.getHkid();
    }

    public PersonEntity() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<CourseEntity> getCourseTeaching() {
        return courseTeaching;
    }

    public void setCourseTeaching(List<CourseEntity> courseTeaching) {
        this.courseTeaching = courseTeaching;
    }

    public List<CourseEntity> getCourseAttending() {
        return courseAttending;
    }

    public void setCourseAttending(List<CourseEntity> courseAttending) {
        this.courseAttending = courseAttending;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHkid() {
        return hkid;
    }

    public void setHkid(String hkid) {
        this.hkid = hkid;
    }
}
