package org.example.jpapractice.domain.comment.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.example.jpapractice.domain.member.entity.Member;
import org.example.jpapractice.domain.post.entity.Post;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;



@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="comment")
@SequenceGenerator( name = "COMMENT_SEQ_GENERATOR",
//        sequenceName = "COMMENT_SEQ",
        initialValue = 1, allocationSize = 1)
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SEQ_GENERATOR")
    @Column(name="comment_id")
    private Long id;

    // 일단 순환참조를 위한 칼럼 나중에 파악하고 작성하자.
    private Long parent_id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @OneToMany(mappedBy = "comment",fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<CommentLike> commentLikes;


    @Column(name="content", nullable=false)
    private String content;


}
