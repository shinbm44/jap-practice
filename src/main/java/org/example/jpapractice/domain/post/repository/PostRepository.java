package org.example.jpapractice.domain.post.repository;


import org.example.jpapractice.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {



}
