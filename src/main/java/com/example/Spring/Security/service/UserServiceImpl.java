package com.example.Spring.Security.service;

import com.example.Spring.Security.dto.*;
import com.example.Spring.Security.entity.RoleEntity;
import com.example.Spring.Security.entity.UserEntity;
import com.example.Spring.Security.repository.BlogRepo;
import com.example.Spring.Security.repository.RoleRepository;
import com.example.Spring.Security.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BlogRepo blogRepo;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,BlogRepo blogRepo) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.blogRepo=blogRepo;
    }

//    @Override
//    public ResponseEntity<String> registerUser(RegisterUserDto registerUserDto) {
//        if(userRepository.existsByEmail(registerUserDto.getEmail())){
//            return new ResponseEntity<>(registerUserDto.getFullname() + " is already registered", HttpStatus.FOUND);
//        }
//        User newUser = new User();
//        RoleEntity role  = roleRepository.findByName("USER").get();
//        newUser.setFullname(registerUserDto.getFullname());
//        newUser.setEmail(registerUserDto.getEmail());
//        newUser.setPassword(registerUserDto.getPassword());
//        newUser.setUsername(registerUserDto.getUsername());
//        newUser.setRoles(Collections.singleton(role));
//        newUser.setBlogs(registerUserDto.getBlogs());
//        newUser.setRoles(Collections.singleton(role));
//        userRepository.save(newUser);
//        return new ResponseEntity<>("Welcome " + newUser.getFullname() + ", your account is registered", HttpStatus.OK);
//    }

    @Override
    public ResponseEntity<String> updateUser(RegisterUserDto registerUserDto) {
        if(userRepository.existsByEmail(registerUserDto.getEmail())){
            UserEntity newUser = userRepository.findByEmail(registerUserDto.getEmail()).get();
//            RoleEntity role  = roleRepository.findByName("USER").get();
            newUser.setFirstName(registerUserDto.getFirstname());
            newUser.setEmail(registerUserDto.getEmail());
            newUser.setPassword(registerUserDto.getPassword());
            newUser.setUsername(registerUserDto.getUsername());
            //  newUser.setRoles(Collections.singleton(role));
//            newUser.setBlogs(registerUserDto.getBlogs());
            //   .roles(Collections.singleton(role));
//        newBlog.setComments(blogDto.get);
            //          newUser.setRoles(registerUserDto.getRoles());
            //         newUser.setBlogs(registerUserDto.getBlogs());
            userRepository.save(newUser);
            return new ResponseEntity<>(newUser.getFirstName() + "Your account has been updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> deleteUser(DeleteDto deleteDto) {
        if(userRepository.existsByEmail(deleteDto.getEmail())){
            UserEntity user =    userRepository.findByEmail(deleteDto.getEmail()).get();
            userRepository.delete(user);
            return new ResponseEntity<>("User has been deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("User cannot be deleted because it does not exist",HttpStatus.NOT_FOUND);
    }

    @Override
    public List<FetchAllUserDto> fetchAllUser() {
        List<UserEntity> allUser = userRepository.findAll();

        return allUser.stream().map(user->FetchAllUserDto.builder()
                .fullname(user.getFirstName()).email(user.getEmail())
                .username(user.getUsername())
                .email(user.getEmail()).build()).collect(Collectors.toList());
    }

//    @Override
//    public ResponseEntity<FetchSingleUserResponseDto> fetchASingleUser(DeleteDto deleteDto) {
//        if(!userRepository.existsByEmail(deleteDto.getEmail())){
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//        UserEntity user = userRepository.findByEmail(deleteDto.getEmail()).get();
//        RoleEntity role = user.getRole().iterator().next();
//
//
//
//
//        return new ResponseEntity<>(FetchSingleUserResponseDto.builder()
//                .fullname(user.getFirstName()).username(user.getUsername())
//                .email(user.getEmail())
//                .roleName(role.getName())
//                .blogs(user.getBlogs()).build(),HttpStatus.OK);
//    }



    @Override
    public ResponseEntity<String> deleteSingleBlog(DeleteBlogUsingUser deleteBlogUsingUser) {
        if(userRepository.existsByEmail(deleteBlogUsingUser.getEmail())){
            UserEntity user = userRepository.findByEmail(deleteBlogUsingUser.getEmail()).get();
            blogRepo.deleteById(deleteBlogUsingUser.getBlogIdNumber());
            return new ResponseEntity<>("Blog post has been deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Blog does not exist", HttpStatus.NOT_FOUND);
    }

}
