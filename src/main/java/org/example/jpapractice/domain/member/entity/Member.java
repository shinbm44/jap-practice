package org.example.jpapractice.domain.member.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.jpapractice.domain.comment.entity.CommentLike;
import org.example.jpapractice.domain.comment.entity.Comments;
import org.example.jpapractice.domain.post.entity.Post;
import org.example.jpapractice.domain.post.entity.PostLike;


import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="member")
@SequenceGenerator( name = "MEMBER_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 1)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long memberId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="login_type_id", nullable=false)
    @ToString.Exclude
    private LoginType loginType;

    @Column(name="email", unique=true, nullable=false)
    private String email;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="image_src", nullable=false)
    private String img;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Comments> comments;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<CommentLike> commentLikes = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<PostLike> postLikes = new ArrayList<>();

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<MemberRole> memberRoles = new ArrayList<>();


}
