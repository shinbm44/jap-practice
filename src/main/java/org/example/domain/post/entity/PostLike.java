package org.example.domain.post.entity;

import jakarta.persistence.*;
import lombok.ToString;
import org.example.domain.member.entity.Member;

@Entity
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_like_id")
    private long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", unique=true, nullable=false)
    @ToString.Exclude
    private long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memner_id", unique=true, nullable=false)
    @ToString.Exclude
    private Member member;

    @Column(name="is_like", nullable=false)
    private boolean liked;



}
