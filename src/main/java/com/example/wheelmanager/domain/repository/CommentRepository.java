package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {


}
