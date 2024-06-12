package org.example.domain.member.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.domain.comment.entity.Comment;
import org.example.domain.comment.entity.CommentLike;
import org.example.domain.post.entity.Post;
import org.example.domain.post.entity.PostLike;
import org.hibernate.annotations.processing.Pattern;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id", nullable = false)
    private Long id;

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
    private List<Comment> comments = new ArrayList<>();

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
