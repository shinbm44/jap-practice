package org.example.domain.member.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.processing.Pattern;

@Entity
@Getter
@NoArgsConstructor
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="login_type_id")
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




}
