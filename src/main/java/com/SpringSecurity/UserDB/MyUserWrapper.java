package com.SpringSecurity.UserDB;

public class MyUserWrapper {
    private String userName;
    private String password;
    private boolean isDevloper;
    public MyUser to(){
        return MyUser.builder().userName(userName).password(password).authorities(isDevloper==true?"devloper":"devops").build();
    }
}
