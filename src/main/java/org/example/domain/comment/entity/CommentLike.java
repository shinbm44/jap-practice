package org.example.domain.comment.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.domain.member.entity.Member;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="comment_like")
@SequenceGenerator( name = "COMMENT_LIKE_SEQ_GENERATOR",
//        sequenceName = "COMMENT_LIKE_SEQ",
        initialValue = 1, allocationSize = 1)
public class CommentLike {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_LIKE_SEQ_GENERATOR")
    @Column(name="comment_like_id")
    private Long commentLikeId;

    @ManyToOne
    @JoinColumn(name="comment_id", unique = true, nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Comments comment;


    @ManyToOne
    @JoinColumn(name="member_id", unique = true, nullable = false)
    @ToString.Exclude
    private Member member;

    @Column(name="is_like", nullable = false)
    private Boolean isLike;

}
