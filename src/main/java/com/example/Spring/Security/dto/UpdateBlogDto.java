package com.example.Spring.Security.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBlogDto {
    private String emailAddress;
    private String title;
    private String content;
    private String author;
    private Date createdAt;
    private long blogNumber;
}
