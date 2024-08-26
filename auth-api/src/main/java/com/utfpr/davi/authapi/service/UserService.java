package com.utfpr.davi.authapi.service;

import com.utfpr.davi.authapi.dto.UserRegisterDTO;
import com.utfpr.davi.authapi.entity.User;
import com.utfpr.davi.authapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void save(UserRegisterDTO user){

        if(userRepository.findByEmail(user.email()).isPresent()){
            throw new IllegalArgumentException("Email já cadastrado");
        }

        String encryptPassword = encoder.encode(user.password());

        User userEntity = new User(
                user.username(),
                user.email(),
                encryptPassword
        );

        this.userRepository.save(userEntity);
    }


}
