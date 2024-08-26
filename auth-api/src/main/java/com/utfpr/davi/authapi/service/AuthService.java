package com.utfpr.davi.authapi.service;

import com.utfpr.davi.authapi.dto.UserLoginDTO;
import com.utfpr.davi.authapi.entity.User;
import com.utfpr.davi.authapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private TokenService tokenService;


    public String login(UserLoginDTO userDTO){
        String token = null;
            User user = this.userRepository.findByEmail(userDTO.email()).orElseThrow(RuntimeException::new);
            if(encoder.matches(userDTO.password(),user.getPassword())){
                token =  this.tokenService.generateToken(userDTO.email());
            }
        return token;
    }

}
