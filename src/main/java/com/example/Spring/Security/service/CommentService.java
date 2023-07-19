package com.example.Spring.Security.service;

import com.example.Spring.Security.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    CommentResponseDto postNewComment(CommentDto commentDto);

    List<BlogCommentList> getAllCommentsByBlogId(Long id);

    ResponseEntity<NewCommentResponseDto> updateComment (UpdateCommentDto updateCommentDto);

}
