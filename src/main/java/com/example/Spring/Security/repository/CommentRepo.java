package com.example.Spring.Security.repository;

import com.example.Spring.Security.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    @Query("select c from Comment c where c.blog.id = ?1")
    List<Comment> getAllCommentsByBlogId(Long id);

    @Query("select (count(c) > 0) from Comment c where c.author = ?1")
    boolean existsByAuthorName(String author);

    @Query("select c from Comment c where c.author = ?1")
    Optional<Comment> findByAuthor(String author);}

