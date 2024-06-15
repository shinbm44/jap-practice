package org.example.jpapractice.domain.post.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.jpapractice.domain.comment.entity.Comments;
import org.example.jpapractice.domain.member.entity.Member;


import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="post")
@SequenceGenerator( name = "POST_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 1)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_SEQ_GENERATOR")
    @Column(name ="post_id")
    private long id;

    @Column(name ="title", nullable = false)
    private String title;

    @Column(name ="content", nullable = false)
    @Lob // long Text 형태
    private String content;

    @OneToMany(mappedBy = "post" , fetch = FetchType.LAZY )
    @ToString.Exclude
    private List<Comments> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post" , fetch = FetchType.LAZY )
    @ToString.Exclude
    private List<PostImage> postImages = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id", nullable = false)
    @ToString.Exclude
    private Member member;


    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<PostLike> postLikes = new ArrayList<>();

}
