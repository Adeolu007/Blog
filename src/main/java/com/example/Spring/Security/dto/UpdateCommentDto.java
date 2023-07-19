package com.example.Spring.Security.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCommentDto {
    private String author;
    private String content;
    private long blogIdNumber;
}
