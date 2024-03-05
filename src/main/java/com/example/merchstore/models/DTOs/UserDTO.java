package com.example.merchstore.models.DTOs;

import com.example.merchstore.models.entities.User;
import com.example.merchstore.models.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class UserDTO {

    private Long id;
    private String email;
    private String lastName;
    private String firstName;
    private Role role;

    public static UserDTO toDTO (User user) {

        if (user == null)
            return null;

        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
