package org.example.jpapractice.domain.post.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.jpapractice.domain.post.dto.PostDTO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 데이터 검증 이유

// 1. client 개발자가 깜박할 수 있다. 실수로 값을 안보낼 수 있다.
// 2. clinet bug로 값이 누락될 수 있다.
// 3. 외부에 나쁜 사람이 값을 임의 로 조작해서 보낼 수 있다.
// 4. DB에 값을 저장할 때 의도치 않은 오류가 발생할 수 있다.
// 5. 서버 개발자의 편안함을 위해서


@RestController
@RequestMapping("/api")
@Slf4j
public class PostController {

    @PostMapping("/posts")
    public Map<String, String> getPosts(@RequestBody @Valid PostDTO postDTO, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            FieldError error = errors.get(0);
            String filedName = error.getField(); // title
            String errorMessage = error.getDefaultMessage(); // ..에러 메세지

            Map<String, String> errorMap = new HashMap<>();
            errorMap.put(filedName, errorMessage);
            return errorMap;
        }

        log.info("postDTO: {}", postDTO.toString());
        return Map.of();
    }

}
