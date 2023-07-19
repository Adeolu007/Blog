package com.example.Spring.Security.repository;

import com.example.Spring.Security.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog,Long> {
}
