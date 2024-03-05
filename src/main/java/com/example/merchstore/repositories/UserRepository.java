package com.example.merchstore.repositories;

import com.example.merchstore.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> getUserByEmail(String email);
    boolean existsByEmail(String s);
}
