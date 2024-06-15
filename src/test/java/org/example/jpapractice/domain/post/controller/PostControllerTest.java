package org.example.jpapractice.domain.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.jpapractice.domain.post.dto.PostDTO;
import org.example.jpapractice.domain.post.entity.Post;
import org.example.jpapractice.domain.post.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.awaitility.Awaitility.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@WebMvcTest
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @MockBean
    private PostDTO postDTO;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    @DisplayName("/post 요청시 title 값은 필수이다. ")
     void test3() throws Exception {

        PostDTO postDTO = PostDTO.builder()
                .title(null)
                .content("내용입니다.")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(postDTO))
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("400"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("잘못된 요청입니다."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.validation.title").value("제목을 입력해주세요"))
                .andDo(MockMvcResultHandlers.print());
    }

//    postService
    @Test
    @DisplayName("/post 요청 시(PostController) ")
    void test4() throws Exception {

        PostDTO postDTO = new PostDTO().builder()
                .title("제목입니다.")
                .content("내용입니다.")
                .build();
        //given
        doNothing().when(postService).write(any(PostDTO.class));

        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDTO))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{}"))
                .andDo(MockMvcResultHandlers.print());

        //then
        //postService의 write 메서드가 한 번 호출인지 검증
        //.write(any(PostDTO.class)): PostDTO 타입의 어떤 인자를 받는 write 메서드 호출을 검증합니다.
        verify(postService, times(1)).write(any(PostDTO.class));
    }
}