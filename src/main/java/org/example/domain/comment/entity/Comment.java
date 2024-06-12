package org.example.domain.comment.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.domain.member.entity.Member;
import org.example.domain.post.entity.Post;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private Long id;

    // 일단 순환참조를 위한 칼럼 나중에 파악하고 작성하자.
    private Long parent_id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
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
