package org.example.domain.member.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name ="login_type")
public class LoginType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="login_type_id")
    private Long id;


    @Column(name="name", nullable=false)
    private String name;

    @OneToMany(mappedBy = "login_type", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Member> memberList = new ArrayList<>();



}
