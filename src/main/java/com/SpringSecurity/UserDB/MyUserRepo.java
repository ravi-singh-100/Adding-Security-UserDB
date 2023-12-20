package com.SpringSecurity.UserDB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser,Integer> {
   MyUser findByUserName(String username);
}
