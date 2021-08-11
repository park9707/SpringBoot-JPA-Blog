package com.cos.blog.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity //User 클래스가 MySQL에 테이블이 생성된다.
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false, length=30)
    private String username;

    @Column(nullable=false, length=100)
    private String password;

    @Column(nullable=false, length=50)
    private String email;

    @ColumnDefault("'user'")
    private String role;

    @CreationTimestamp //시간이 자동 입력
    private Timestamp createDate;
}
