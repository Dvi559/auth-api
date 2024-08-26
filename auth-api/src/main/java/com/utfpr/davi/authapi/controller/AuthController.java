package com.utfpr.davi.authapi.controller;

import com.utfpr.davi.authapi.dto.ResponseDTO;
import com.utfpr.davi.authapi.dto.UserLoginDTO;
import com.utfpr.davi.authapi.service.AuthService;
import com.utfpr.davi.authapi.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity<?> authLogin (@RequestBody UserLoginDTO userDTO){
        String token = authService.login(userDTO);
          if(token == null) {
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
          }
        return ResponseEntity.ok(new ResponseDTO(userDTO.email(),token));
    }

    @PostMapping("/validate")
    public ResponseEntity<?> authValidate(@RequestBody String token){
        String validate = this.tokenService.validateToken(token);
        if(validate == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(validate);
    }






}
