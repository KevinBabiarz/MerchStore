package com.example.merchstore.services.impl;

import com.example.merchstore.exceptions.AlreadyExistException;
import com.example.merchstore.exceptions.NotFoundException;
import com.example.merchstore.exceptions.NotTheGoodPasswordException;
import com.example.merchstore.repositories.UserRepository;
import com.example.merchstore.services.notImpl.UserService;
import com.example.merchstore.models.entities.User;
import com.example.merchstore.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository ;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(
            UserRepository userRepository,
            JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }
    @Override
    public User login(User user) {



        User existingUser = userRepository.getUserByEmail(user.getEmail()).orElseThrow(()-> new NotFoundException(user.getId(),UserServiceImpl.class.toString()));

        if(!existingUser.getPassword().equals(user.getPassword())){
            throw new NotTheGoodPasswordException(user.getId(), user.getEmail());
        }


        return existingUser;
    }

    @Override
    public User getOne(Long idUser) {
        return userRepository.findById(idUser).orElseThrow(()->new NotFoundException(idUser,UserServiceImpl.class.toString()));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Long register(User user) {
        user.setId(null);
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new AlreadyExistException(user.getId(),UserServiceImpl.class.toString());
        }
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByEmail(username).orElseThrow();
    }
}
