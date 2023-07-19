package com.example.Spring.Security.dto;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResponseDto {
    private String blogTitle;
    private String blogContent;
    private String blogAuthor;
    private Date blogCreatedAt;

    private String author;
    private String content;
    private Date createdAt;
    private long blogNumber;
}
