package org.example.jpapractice.domain.member.entity;


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
@Table(name="member_role")
@SequenceGenerator( name = "MEMBER_ROLE_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 1)
public class MemberRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_ROLE_SEQ_GENERATOR")
    @Column(name="member_role_id", nullable = false)
    private Long memberRoleId;

    @ManyToOne
    @JoinColumn(name="role_id",unique = true,nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Role role;

    @ManyToOne(optional = false)
    @JoinColumn(name="member_id",unique = true ,nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Member member;

}
