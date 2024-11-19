package com.fsse2410.BBB02_.data.example1;

import jakarta.persistence.*;

import java.util.Set;


//假設我們有兩個實體：Student 和 Course，每個學生可以選修多門課程，而每門課程也可以被多個學生選修。
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    //@JoinTable 是在 Spring Boot 中處理多對多關聯時的重要註解。通過合理配置中介表，你可以清晰地定義實體之間的關聯，
    // 並在數據庫中保持數據的完整性和一致性。
    @ManyToMany
    @JoinTable(
            name = "student_course", // 中介表名稱
            joinColumns = @JoinColumn(name = "student_id"), // 外鍵列，指向 Student
            inverseJoinColumns = @JoinColumn(name = "course_id") // 外鍵列，指向 Course
    )
    private Set<Course> courses;
}
