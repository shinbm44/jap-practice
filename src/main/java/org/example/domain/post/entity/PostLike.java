package org.example.domain.post.entity;

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
@Table(name="post_like")
@SequenceGenerator( name = "POST_LIKE_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 1)
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_LIKE_SEQ_GENERATOR")
    @Column(name="post_like_id")
    private long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", unique=true, nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id", unique=true, nullable=false)
    @ToString.Exclude
    private Member member;

    @Column(name="is_like", nullable=false)
    private boolean liked;



}
