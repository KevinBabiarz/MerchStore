package com.example.merchstore.services.notImpl;
import com.example.merchstore.models.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User login(User user);

    User getOne(Long idUser);

    List<User> getAllUser();

    Long register(User user);
}
