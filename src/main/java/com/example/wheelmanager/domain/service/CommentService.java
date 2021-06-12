package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    Page<Comment> getAllComments(Pageable pageable);

    Comment getCommentById(Long commentId);

    Comment createComment(Long userId, Long vehicleId, Comment comment);

    Comment updateComment(Long commentId, Comment messageRequest);

    ResponseEntity<?> deleteComment(Long commentId);
}
