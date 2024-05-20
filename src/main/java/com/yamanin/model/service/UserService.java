package com.yamanin.model.service;

import java.util.Optional;

import com.yamanin.model.dto.User;

public interface UserService {
    User getUserById(int userId);

    boolean writeUser(User user);

    boolean removeUser(int userId);

    boolean modifyUser(User user);

    Optional<User> findByLoginId(String loginId);
}
