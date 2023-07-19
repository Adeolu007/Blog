package com.example.Spring.Security.service;

import com.example.Spring.Security.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    //    ResponseEntity<String> registerUser(RegisterUserDto registerUserDto);
    ResponseEntity<String> updateUser (RegisterUserDto registerUserDto);
    ResponseEntity<String> deleteUser (DeleteDto deleteDto);
    List<FetchAllUserDto> fetchAllUser();
//    ResponseEntity<FetchSingleUserResponseDto> fetchASingleUser(DeleteDto deleteDto);
    ResponseEntity<String> deleteSingleBlog (DeleteBlogUsingUser deleteBlogUsingUser);

}
