package org.example.jpapractice.domain.post.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jpapractice.domain.post.dto.CreatePostDto;
import org.example.jpapractice.domain.post.dto.GetPostDto;
import org.example.jpapractice.domain.post.service.PostService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 데이터 검증 이유

// 1. client 개발자가 깜박할 수 있다. 실수로 값을 안보낼 수 있다.
// 2. clinet bug로 값이 누락될 수 있다.
// 3. 외부에 나쁜 사람이 값을 임의 로 조작해서 보낼 수 있다.
// 4. DB에 값을 저장할 때 의도치 않은 오류가 발생할 수 있다.
// 5. 서버 개발자의 편안함을 위해서


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<String> getPosts(@RequestBody @Valid CreatePostDto postDTO) {

        postService.write(postDTO);

        return ResponseEntity.ok( "Create");
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<GetPostDto> getPost(@PathVariable("id") long id)  {
        GetPostDto getPostDto = postService.read(id);

        return ResponseEntity.ok(getPostDto);
    }
}
