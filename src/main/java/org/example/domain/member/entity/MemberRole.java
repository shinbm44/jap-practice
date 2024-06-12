package org.example.domain.member.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class MemberRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_role_id", nullable = false)
    private Long memberRoleId;

    @ManyToOne
    @JoinColumn(name="role_id",unique = true,nullable = false)
    @ToString.Exclude
    private Role role;

    @ManyToOne(optional = false)
    @JoinColumn(name="member_id",unique = true ,nullable = false)
    @ToString.Exclude
    private Member member;

}
