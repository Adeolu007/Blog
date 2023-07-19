package com.example.Spring.Security.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteBlogUsingUser {
    private String email;
    private long blogIdNumber;
}
