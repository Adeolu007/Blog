package com.example.Spring.Security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FetchingSingleBlogDto {
    private String email;
    private String password;
    private long blogIdNumber;
}
