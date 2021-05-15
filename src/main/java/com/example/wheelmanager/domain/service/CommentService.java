package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CommentService {

    Page<Comment> getAllCommentsByUserId(Long userId, Pageable pageable);
    Page<Comment> getAllCommentsByVehicleId(Long vehicleId, Pageable pageable);
    Comment getCommentsByIdByUserIdAndAddressId(Long userId, Long vehicleId, Long commentId);
    Comment createComment(Long userId,Long vehicleId,Comment comment);
    Comment updateComment(Long userId,Long vehicleId,Long commentId,Comment messageRequest);
    ResponseEntity<?> deleteComment(Long userId, Long vehicleId, Long commentId);

}
