package com.SpringSecurity.UserDB;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUserWrapper {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Value("${user.authority.devloper}")
    private String DEVLOPER_AUTHORITY;
    @Value("${user.authority.devops")
    private String DEVOPS_AUTHORITY;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @NotNull
    private boolean isDevloper;

    public MyUser to(){
//        return MyUser.builder().userName(userName).password(passwordEncoder.encode(password)).authorities(isDevloper==true?DEVLOPER_AUTHORITY:DEVOPS_AUTHORITY).build();
   MyUser myUser=new MyUser();
   myUser.setUserName(userName);
   myUser.setPassword(passwordEncoder.encode(password));
   myUser.setAuthorities(isDevloper==true?DEVLOPER_AUTHORITY:DEVOPS_AUTHORITY);
   return myUser;


    }
}
