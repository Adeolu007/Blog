package com.example.Spring.Security.dto;

import lombok.*;

import java.util.Date;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogListDto {
    private String title;
    private String content;
    private String author;
    private Date createdAt;
    private List<BlogCommentList> commentLists;

}
