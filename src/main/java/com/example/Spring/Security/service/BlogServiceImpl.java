package com.example.Spring.Security.service;

import com.example.Spring.Security.dto.BlogDto;
import com.example.Spring.Security.dto.BlogListDto;
import com.example.Spring.Security.dto.BlogResponseDto;
import com.example.Spring.Security.dto.UpdateBlogDto;
import com.example.Spring.Security.entity.Blog;
import com.example.Spring.Security.repository.BlogRepo;
import com.example.Spring.Security.repository.CommentRepo;
import com.example.Spring.Security.repository.RoleRepository;
import com.example.Spring.Security.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepo blogRepo;
    private CommentRepo commentRepo;
    private CommentService commentService;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//    private AuthenticationManager authenticationManager;

    private BlogServiceImpl(BlogRepo blogRepo, CommentRepo commentRepo, CommentService commentService,RoleRepository roleRepository, UserRepository userRepository){
        this.blogRepo = blogRepo;
        this.commentRepo = commentRepo;
        this.commentService = commentService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;

//    this.passwordEncoder = passwordEncoder;
//    this.authenticationManager = authenticationManager;

    }

    @Override
    public BlogResponseDto newBlogPost(BlogDto blogDto) {
        Blog newBlog = new Blog();
        if(!userRepository.existsByEmail(blogDto.getEmailAddress())){
            return null;
        }
        newBlog.setAuthor(blogDto.getAuthor());
        newBlog.setTitle(blogDto.getTitle());
        newBlog.setCreatedAt(blogDto.getCreatedAt());
        newBlog.setContent(blogDto.getContent());//
        //      .roles(Collections.singleton(role));
//        newBlog.setComments(blogDto.get);

        blogRepo.save(newBlog);
        return BlogResponseDto.builder()
                .title(newBlog.getTitle())
                .author(newBlog.getAuthor())
                .content(newBlog.getContent())
                .createdAt(newBlog.getCreatedAt())
                .build();
    }

    @Override
    public List<BlogListDto> getAllBlogPost() {
        List<Blog> blogs = blogRepo.findAll();
        return blogs.stream().map((blog ->
                BlogListDto.builder()
                        .title(blog.getTitle())
                        .createdAt(blog.getCreatedAt())
                        .content(blog.getContent())
                        .commentLists(commentService.getAllCommentsByBlogId(blog.getId()))
                        .build()
        )).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<BlogResponseDto> updateBlog(UpdateBlogDto updateBlogDto) {
        if(userRepository.existsByEmail(updateBlogDto.getEmailAddress()) && blogRepo.existsById(updateBlogDto.getBlogNumber())){
            Blog blog = blogRepo.findById(updateBlogDto.getBlogNumber()).get();
            blog.setTitle(updateBlogDto.getTitle());
            blog.setContent(updateBlogDto.getContent());
            blogRepo.save(blog);

            return new ResponseEntity<>(BlogResponseDto.builder()
                    .author(blog.getAuthor()).content(blog.getContent())
                    .title(blog.getTitle()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }


}



