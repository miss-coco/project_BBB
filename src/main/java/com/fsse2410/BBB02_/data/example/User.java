package com.fsse2410.BBB02_.data.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
//假設有兩個實體：User 和 Post，一個用戶可以有多個帖子，而每個帖子只屬於一個用戶。

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    //在 User 類中，@OneToMany(mappedBy = "user") 表示 User 是非擁有方，posts 是用來映射 Post 實體的集合。
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

}
