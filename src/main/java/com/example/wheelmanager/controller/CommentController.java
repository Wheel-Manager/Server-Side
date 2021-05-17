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


    @GetMapping("/comments")
    public Page<CommentResource> getAllComments(Pageable pageable) {
        Page<Comment> commentPage = commentService.getAllComments(pageable);
        List<CommentResource> resources = commentPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }


    @GetMapping("/comments/{commentId}")
    public CommentResource getCommentById(@PathVariable(value = "commentId") Long commentId) {
        return convertToResource(commentService.getCommentById(commentId));
    }

    @PostMapping("/comments")
    public CommentResource createReservation(@RequestParam(name = "user_id") Long userId, @RequestParam(name = "vehicle_id") Long vehicleId, @Valid @RequestBody SaveCommentResource resource) {
        return convertToResource(commentService.createComment(userId, vehicleId, convertToEntity(resource)));
    }

    @PutMapping("/comments/{commentId}")
    public CommentResource updateComment(@PathVariable(value = "commentId") Long commentId, @Valid @RequestBody SaveCommentResource resource) {
        return convertToResource(commentService.updateComment(commentId, convertToEntity(resource)));
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "commentId") Long commentId) {
        return commentService.deleteComment(commentId);
    }


    private Comment convertToEntity(SaveCommentResource resource) {
        return mapper.map(resource, Comment.class);
    }

    private CommentResource convertToResource(Comment entity) {
        return mapper.map(entity, CommentResource.class);
    }
}



