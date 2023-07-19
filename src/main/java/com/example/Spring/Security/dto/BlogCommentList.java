package com.example.Spring.Security.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogCommentList {
    private String author;
    private String content;
}
