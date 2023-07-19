package com.example.Spring.Security.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FetchAllUserDto {
    private String fullname;
    private String username;
    private String email;
}
