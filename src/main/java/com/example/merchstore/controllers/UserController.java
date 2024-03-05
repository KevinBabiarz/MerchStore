package com.example.merchstore.controllers;

import com.example.merchstore.models.DTOs.UserDTO;
import com.example.merchstore.models.DTOs.UserTokenDTO;
import com.example.merchstore.models.entities.User;
import com.example.merchstore.models.forms.UserLoginForm;
import com.example.merchstore.models.forms.UserRegisterForm;
import com.example.merchstore.services.notImpl.UserService;
import com.example.merchstore.utils.JwtUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin("*")
@RestController
@Slf4j
public class UserController {
    private UserService userService;
    private JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenDTO> login(@RequestBody @Valid UserLoginForm userLoginForm) {
        User user = userService.login(userLoginForm.toEntity());
        UserTokenDTO dto = UserTokenDTO.fromEntity(user);
        dto.setToken(jwtUtil.generateToken(user));
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody @Valid UserRegisterForm userRegisterForm) {

        User user = userRegisterForm.toEntity();
        Long register = userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user.getId());
    }

    @GetMapping("/user/{id:[0-9]+}")
//    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<UserDTO> getOne(@RequestBody @PathVariable Long id){
        User user = userService.getOne(id);
        UserDTO userDTO = UserDTO.toDTO(user);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

}
