package com.cos.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content;

    private int count; //조회수

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @OneToMany(mappedBy="board",fetch=FetchType.EAGER,cascade = CascadeType.REMOVE) // cascade 게시글을 지울 때 댓글도 다 지워버리겠다는것
    @JsonIgnoreProperties({"board"}) // 무한참조 해결
    @OrderBy("id desc") // 아이디 기준 내림차순으로 정렬
    private List<Reply> replys;

    @CreationTimestamp
    private Timestamp createDate;
}
