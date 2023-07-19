package com.example.Spring.Security.controller;

import com.example.Spring.Security.dto.*;
import com.example.Spring.Security.service.BlogService;
import com.example.Spring.Security.service.CommentService;
import com.example.Spring.Security.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private BlogService blogService;
    private CommentService commentService;
    private UserService userService;

    public BlogController(BlogService blogService,CommentService commentService,UserService userService){
        this.blogService = blogService;
        this.commentService = commentService;
        this.userService=userService;
    }

    //new user
//    @PostMapping("/newUser")
//    public ResponseEntity<String> registerUser(@RequestBody RegisterUserDto registerUserDto) {
//        return userService.registerUser(registerUserDto);
//    }
    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody RegisterUserDto registerUserDto) {
        return userService.updateUser(registerUserDto);
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody DeleteDto deleteDto) {
        return userService.deleteUser(deleteDto);
    }

    @GetMapping("/allUser")
    public List<FetchAllUserDto> fetchAllBlogs() {
        return userService.fetchAllUser();
    }

    //not resolved/ bug found
//    @GetMapping("/singleUser")
//    public ResponseEntity<FetchSingleUserResponseDto> fetchASingleUser(@RequestBody DeleteDto deleteDto) {
//        return userService.fetchASingleUser(deleteDto);
//    }
    @DeleteMapping("delete_Single_User")
    public ResponseEntity<String> deleteSingleBlog(DeleteBlogUsingUser deleteBlogUsingUser) {
        return userService.deleteSingleBlog(deleteBlogUsingUser);
    }

    //main blog controller
    @PostMapping("/newPost")
    public BlogResponseDto newBlogPost(@RequestBody BlogDto blogDto) {
        return blogService.newBlogPost(blogDto);
    }

    //comment
    @PostMapping("/newComment")
    public CommentResponseDto postNewComment(@RequestBody CommentDto commentDto) {
        return commentService.postNewComment(commentDto);
    }

    @GetMapping
    public ResponseEntity<List<BlogListDto>> getAllBlogPosts(){
        return new ResponseEntity<>(blogService.getAllBlogPost(), HttpStatus.OK);
    }

    @PutMapping("/updateComment")
    public ResponseEntity<NewCommentResponseDto> updateComment(@RequestBody UpdateCommentDto updateCommentDto) {
        return commentService.updateComment(updateCommentDto);
    }

    //ResponseEntity<NewCommentResponseDto> updateComment ( UpdateCommentDto updateCommentDto);

    @PutMapping("/updateBlog")
    public ResponseEntity<BlogResponseDto> updateBlog(@RequestBody UpdateBlogDto updateBlogDto) {
        return blogService.updateBlog(updateBlogDto);
    }
    @GetMapping("/enter")
    public String simpleHello(){
        return "Hello World";
    }
}
