package org.example.jpapractice.domain.member.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="login_type")
@SequenceGenerator( name = "LOGIN_TYPE_SEQ_GENERATOR",
//        sequenceName = "LOGIN_TYPE_SEQ",
        initialValue = 1, allocationSize = 1)
public class LoginType {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOGIN_TYPE_SEQ_GENERATOR")
    @Column(name="login_type_id")
    private Long id;


    @Column(name="name", nullable=false)
    private String name;

    @OneToMany(mappedBy = "login_type", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Member> memberList = new ArrayList<>();



}
