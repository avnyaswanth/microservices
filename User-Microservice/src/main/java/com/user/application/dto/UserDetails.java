package com.user.application.dto;


import com.user.application.entity.Userr;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    private Userr user;
    private Department department;
}
