package org.example.domain.member.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Long id;


    @Column(name="name", unique = true,nullable = false)
    private String name;

    @OneToMany(mappedBy = "Role",fetch = FetchType.LAZY)
    @JoinColumn(name="role_id")
    private List<MemberRole> memberRoles = new ArrayList<>();

}
