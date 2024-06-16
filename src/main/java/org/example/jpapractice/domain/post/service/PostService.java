package org.example.jpapractice.domain.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jpapractice.domain.post.dto.request.CreatePostDto;
import org.example.jpapractice.domain.post.dto.respnse.GetPostDto;
import org.example.jpapractice.domain.post.entity.Post;
import org.example.jpapractice.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    public void write (CreatePostDto postDTO) {

        Post post = Post.builder()
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .build();

        postRepository.save(post);
    }


    public GetPostDto read (Long id)  {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));

        return GetPostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();

    }

}
