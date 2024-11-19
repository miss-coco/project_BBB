package com.fsse2410.BBB02_.data.example;

import jakarta.persistence.*;

@Entity
public class Post {

    @Id

    //GeneratedValue(strategy = GenerationType.IDENTITY) 是 JPA 中用於自動生成主鍵的註解。
    // 這種策略通常與數據庫的自增列（auto-increment column）結合使用，適用於大多數關係型數據庫。
    //可以是AUTO, IDENTITY, SEQUENCE, TABLE
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    //在 Post 類中，@ManyToOne 表示 Post 擁有對 User 的參考，並通過 @JoinColumn 指定外鍵。
    @ManyToOne

    //1.一對一關聯：在一對一關聯中也可以使用 @JoinColumn，指定一個實體的主鍵同時作為另一個實體的外鍵。
    //2.一對多關聯：在多的一方使用 @JoinColumn 指定外鍵，另一方使用 mappedBy。
    @JoinColumn(name = "user_id")
    private User user;
}
