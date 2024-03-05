package com.example.merchstore.models.forms;

import com.example.merchstore.models.entities.User;
import com.example.merchstore.models.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRegisterForm {

    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private Role role;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;


    public User toEntity(){
        User user = new User();
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setRole(this.role);
        return user;
    }
}
