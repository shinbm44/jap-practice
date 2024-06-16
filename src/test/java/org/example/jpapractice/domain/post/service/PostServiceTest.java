package org.example.jpapractice.domain.post.service;

import org.example.jpapractice.domain.post.dto.CreatePostDto;
import org.example.jpapractice.domain.post.entity.Post;
import org.example.jpapractice.domain.post.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Captor
    private ArgumentCaptor<Post> postCaptor;

    @Test
    @DisplayName("글 작성")
    void test1() {
        // given
        CreatePostDto createPostDTO = CreatePostDto.builder()
                .title("제목입니다.")
                .title("내용입니다")
                .build();

        // when
        postService.write(createPostDTO);

        //then
        verify(postRepository, times(1)).save(postCaptor.capture());

        Post capturedPost = postCaptor.getValue();
        Assertions.assertEquals(createPostDTO.getTitle(), capturedPost.getTitle());
        Assertions.assertEquals(createPostDTO.getContent(), capturedPost.getContent());
    }
}