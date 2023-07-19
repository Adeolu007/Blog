package com.example.Spring.Security.dto;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogResponseDto {
    private String title;
    private String content;
    private String author;
    private Date createdAt;
}
