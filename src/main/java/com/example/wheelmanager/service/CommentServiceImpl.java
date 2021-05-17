package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.Comment;
import com.example.wheelmanager.domain.repository.CommentRepository;
import com.example.wheelmanager.domain.repository.UserRepository;
import com.example.wheelmanager.domain.repository.VehicleRepository;
import com.example.wheelmanager.domain.service.CommentService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;


    /*@Override
    public Page<Comment> getAllCommentsByUserId(Long userId, Pageable pageable) {
        return commentRepository.getAllCommentsByUserId(userId,pageable);
    }

    @Override
    public Page<Comment> getAllCommentsByVehicleId(Long vehicleId, Pageable pageable) {
        return commentRepository.getAllCommentsByVehicleId(vehicleId,pageable);
    }*/


    /*@Override
    public Comment getCommentsByIdByUserIdAndAddressId(Long userId, Long vehicleId, Long commentId) {
        return commentRepository.findByIdAndUserIdAndVehicleId(commentId,userId,vehicleId).
                orElseThrow(()->new ResourceNotFoundException(
                        "Comment not found with Id"+commentId
                                +"and UserId"+userId+"and VehicleId"+vehicleId));

    }*/

    @Override
    public Page<Comment> getAllComments(Pageable pageable)
    {
        return commentRepository.findAll(pageable);
    }



    @Override
    public Comment getCommentById(Long commentId){
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Comment", "Id", commentId));

    }

    @Override
    public Comment createComment(Long userId, Long vehicleId, Comment comment) {
        return userRepository.findById(userId).map(user -> {
            comment.setUser(user);
            return vehicleRepository.findById(vehicleId).map(vehicle -> {
                comment.setVehicle(vehicle);
                return commentRepository.save(comment);
            }).orElseThrow(()->new ResourceNotFoundException("Vehicle","Id",vehicleId));
        }).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
    }

    @Override
    public Comment updateComment(Long commentId, Comment commentRequest) {
        return commentRepository.findById(commentId).map(comment-> {
            comment.setPublicationDate(commentRequest.getPublicationDate())
                    .setContent(commentRequest.getContent());
            return commentRepository.save(comment);
        }).orElseThrow(()->new ResourceNotFoundException("Comment","Id",commentId));
    }

    @Override
    public ResponseEntity<?> deleteComment( Long commentId) {
        return commentRepository.findById(commentId).map(comment-> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("Comment","Id",commentId));
    }

}
