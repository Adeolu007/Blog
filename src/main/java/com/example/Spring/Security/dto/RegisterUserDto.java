package com.example.Spring.Security.dto;

import com.example.Spring.Security.entity.Blog;
import com.example.Spring.Security.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {

    private String firstname;
    private String username;
    private String email;
    private String password;
    private Set<RoleEntity> roles;
    private List<Blog> blogs;
}
