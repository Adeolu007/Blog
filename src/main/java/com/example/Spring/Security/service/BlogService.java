package com.example.Spring.Security.service;

import com.example.Spring.Security.dto.BlogDto;
import com.example.Spring.Security.dto.BlogListDto;
import com.example.Spring.Security.dto.BlogResponseDto;
import com.example.Spring.Security.dto.UpdateBlogDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BlogService {

    BlogResponseDto newBlogPost (BlogDto blogDto);

    List<BlogListDto> getAllBlogPost();

    ResponseEntity<BlogResponseDto> updateBlog (UpdateBlogDto updateBlogDto);

}
