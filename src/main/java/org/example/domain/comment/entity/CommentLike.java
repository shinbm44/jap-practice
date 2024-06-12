package org.example.domain.comment.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.domain.member.entity.Member;

@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="comment_like")
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_like_id", nullable = false)
    private Long commentLikeId;

    @ManyToOne
    @JoinColumn(name="comment_id", unique = true, nullable = false)
    @ToString.Exclude
    private Comment comment;


    @ManyToOne
    @JoinColumn(name="member_id", unique = true, nullable = false)
    @ToString.Exclude
    private Member member;

    @Column(name="is_like", nullable = false)
    private Boolean isLike;

}
