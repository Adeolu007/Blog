package com.example.Spring.Security.service;

import com.example.Spring.Security.dto.*;
import com.example.Spring.Security.entity.Blog;
import com.example.Spring.Security.entity.Comment;
import com.example.Spring.Security.repository.BlogRepo;
import com.example.Spring.Security.repository.CommentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private BlogRepo blogRepo;
    private CommentRepo commentRepo;

    private CommentServiceImpl(BlogRepo blogRepo, CommentRepo commentRepo) {
        this.blogRepo = blogRepo;
        this.commentRepo = commentRepo;
    }

    @Override
    public CommentResponseDto postNewComment(CommentDto commentDto) {
        Comment newComment = new Comment();
        newComment.setAuthor(commentDto.getAuthor());
        newComment.setCreatedAt(commentDto.getCreatedAt());
        newComment.setContent(commentDto.getContent());
        newComment.setBlog(blogRepo.findById(commentDto.getBlogNumber()).get());
        commentRepo.save(newComment);
        Blog blog = blogRepo.findById(commentDto.getBlogNumber()).get();


        return CommentResponseDto.builder()
                .blogTitle(blog.getTitle())
                .blogContent(blog.getContent())
                .blogAuthor(blog.getAuthor())
                .blogCreatedAt(blog.getCreatedAt())
                .author(newComment.getAuthor())
                .content(newComment.getContent())
                .createdAt(newComment.getCreatedAt())
                .build();
    }

    public List<BlogCommentList> getAllCommentsByBlogId(Long id) {
        List<Comment> commentList = commentRepo.getAllCommentsByBlogId(id);
        return commentList.stream().map((eachComment) -> BlogCommentList.builder()
                .author(eachComment.getAuthor())
                .content(eachComment.getContent())
                .build()).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<NewCommentResponseDto> updateComment(UpdateCommentDto updateCommentDto) {
        if(blogRepo.existsById(updateCommentDto.getBlogIdNumber()) && commentRepo.existsByAuthorName(updateCommentDto.getAuthor())){
            Comment comment = commentRepo.findByAuthor(updateCommentDto.getAuthor()).get();
            comment.setContent(updateCommentDto.getContent());
            commentRepo.save(comment);
            return new ResponseEntity<>(NewCommentResponseDto.builder()
                    .author(comment.getAuthor()).content(comment.getContent())
                    .build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
