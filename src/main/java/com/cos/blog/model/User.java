package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //User 클래스가 MySQL에 테이블이 생성된다.
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

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private String oauth; // kakao 로그인 한사람은 kakao가 들어오게, 일반 사용자는 null

    @CreationTimestamp //시간이 자동 입력
    private Timestamp createDate;
}
