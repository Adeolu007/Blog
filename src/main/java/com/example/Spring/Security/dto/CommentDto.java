package com.example.Spring.Security.dto;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private String author;
    private String content;
    private Date createdAt;
    private long blogNumber;
}
