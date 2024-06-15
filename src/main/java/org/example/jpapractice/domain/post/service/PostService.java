package org.example.jpapractice.domain.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jpapractice.domain.post.dto.PostDTO;
import org.example.jpapractice.domain.post.entity.Post;
import org.example.jpapractice.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    public void write (PostDTO postDTO) {

        Post post = Post.builder()
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .build();

        postRepository.save(post);
    }

}
