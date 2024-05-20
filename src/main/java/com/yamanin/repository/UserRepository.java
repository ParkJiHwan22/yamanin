package com.yamanin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yamanin.model.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLoginId(String loginId);
}
