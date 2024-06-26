package org.example.jpapractice.domain.member.controller;

import lombok.RequiredArgsConstructor;

import org.example.jpapractice.domain.member.dto.CreateMember;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    @PostMapping("/join")
    public ResponseEntity<String> createMember(@RequestBody CreateMember CreateMember) {
        return ResponseEntity.ok().body("Successfully created member");
    }






}
