package org.example.domain.post.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="post_image")
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    @ToString.Exclude
    private Post post;

    @Column(name="image_src", nullable = false)
    private String imageSrc;



}
