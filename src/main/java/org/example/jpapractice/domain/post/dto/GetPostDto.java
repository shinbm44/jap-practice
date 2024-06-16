package org.example.jpapractice.domain.post.dto;


import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GetPostDto {

    private long id;
    private String title;
    private String content;
}
