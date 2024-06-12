package org.example.domain.post.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.domain.comment.entity.Comment;
import org.example.domain.member.entity.Member;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="post_id")
    private long id;

    @Column(name ="title", nullable = false)
    private String title;

    @Column(name ="content", nullable = false)
    private String content;

    @OneToMany(mappedBy = "post" , fetch = FetchType.LAZY )
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

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
