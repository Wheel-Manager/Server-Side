package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.Comment;
import com.example.wheelmanager.domain.service.CommentService;
import com.example.wheelmanager.resource.CommentResource;
import com.example.wheelmanager.resource.SaveCommentResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Comments", description = "Comment API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/{user_id}")
    public Page<CommentResource> getAllCommentsByUserId(@PathVariable(name = "user_id") Long userId, Pageable pageable) {
        Page<Comment> reservationPage = commentService.getAllCommentsByUserId(userId, pageable);
        List<CommentResource> resources = reservationPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/comments/{vehicle_id}")
    public Page<CommentResource> getAllCommentsByVehicleId(@PathVariable(name = "vehicle_Id") Long vehicleId, Pageable pageable) {
        Page<Comment> reservationPage = commentService.getAllCommentsByVehicleId(vehicleId, pageable);
        List<CommentResource> resources = reservationPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @PostMapping("/comments")
    public CommentResource createReservation(@RequestParam(name = "user_id") Long userId, @RequestParam(name = "vehicle_id") Long vehicleId, @Valid @RequestBody SaveCommentResource resource) {
        return convertToResource(commentService.createComment(userId, vehicleId, convertToEntity(resource)));
    }

    @PutMapping("/comments/{comment_id}")
    public CommentResource updateComment(@RequestParam(name = "user_id") Long userId, @RequestParam(name = "vehicle_id") Long vehicleId, @PathVariable(value = "comment_id") Long reservationId, @Valid @RequestBody SaveCommentResource resource) {
        return convertToResource(commentService.updateComment(userId, vehicleId, reservationId, convertToEntity(resource)));
    }

    @DeleteMapping("/comments/{comment_id}")
    public ResponseEntity<?> deleteReservation(@RequestParam(name = "user_id") Long userId, @RequestParam(name = "vehicle_id") Long vehicleId, @PathVariable(value = "comment_id") Long commentId) {
        return commentService.deleteComment(userId, vehicleId, commentId);
    }

    private Comment convertToEntity(SaveCommentResource resource) {
        return mapper.map(resource, Comment.class);
    }

    private CommentResource convertToResource(Comment entity) {
        return mapper.map(entity, CommentResource.class);
    }
}



