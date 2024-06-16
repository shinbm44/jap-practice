package org.example.jpapractice.domain.post.service;

import org.example.jpapractice.domain.post.dto.request.CreatePostDto;
import org.example.jpapractice.domain.post.dto.respnse.GetPostDto;
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

import java.util.Optional;

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

    @Test
    @DisplayName("글 1개 조회")
    void test2() {
        Post requestpost = Post.builder()
                .id(1L)
                .title("제목")
                .content("내용")
                .build();

        GetPostDto getPostDto = GetPostDto.builder()
                .id(requestpost.getId())
                .title(requestpost.getTitle())
                .content(requestpost.getContent())
                .build();


        when(postRepository.findById(1L)).thenReturn(Optional.of(requestpost));

        GetPostDto result = postService.read(requestpost.getId());

        Assertions.assertNotNull(result);
        Assertions.assertEquals(getPostDto.getId(), result.getId());
        Assertions.assertEquals(getPostDto.getTitle(), result.getTitle());
        Assertions.assertEquals(getPostDto.getContent(), result.getContent());


        verify(postRepository, times(1)).findById(requestpost.getId());
    }
}