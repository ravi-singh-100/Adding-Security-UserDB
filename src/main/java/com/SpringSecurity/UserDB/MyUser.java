package com.SpringSecurity.UserDB;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Data

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyUser implements UserDetails {
    private static final String delimiter=",";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,unique = true)
    private String userName;
    private String password;
    private String authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        String[]arr=authorities.split(delimiter);
        return Arrays.stream(arr).map(e -> new SimpleGrantedAuthority(e) ).collect(Collectors.toList());
    }
    @Override
   public String getPassword(){
        return this.password;
    }


    @Override
    public String getUsername() {
       return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
