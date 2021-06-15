package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
