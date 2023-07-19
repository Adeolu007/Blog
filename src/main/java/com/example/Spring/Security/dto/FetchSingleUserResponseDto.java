package com.example.Spring.Security.dto;

import com.example.Spring.Security.entity.Blog;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FetchSingleUserResponseDto {
    private String fullname;
    private String username;
    private String email;
    private String roleName;
    private List<Blog> blogs;
}
