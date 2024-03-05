package com.example.merchstore.models.forms;

import com.example.merchstore.models.entities.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginForm {

    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public User toEntity() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
