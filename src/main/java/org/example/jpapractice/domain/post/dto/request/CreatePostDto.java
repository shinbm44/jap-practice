package org.example.jpapractice.domain.post.dto.request;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
// @Builder 어노테이션은 @NoArgsConstructor와 함께 사용되지 않으면 기본 생성자를 생성하지 않는다.
public class CreatePostDto {

    @NotBlank(message = "제목을 입력해주세요")
    private String title;
    @NotBlank(message = "내용을 입력해주세요")
    @Lob
    private String content;

}
