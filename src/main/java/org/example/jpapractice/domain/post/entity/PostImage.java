package org.example.jpapractice.domain.post.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="post_image")
@SequenceGenerator( name = "POST_IMAGE_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 1)
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_IMAGE_SEQ_GENERATOR")
    @Column(name="post_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Post post;

    @Column(name="image_src", nullable = false)
    private String imageSrc;



}
