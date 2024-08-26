package com.utfpr.davi.authapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String email;

    private String password;

    private Date registrationDate;

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
        this.registrationDate = new Date();
    }

     public User (){

     }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
