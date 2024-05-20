package com.yamanin.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamanin.model.dto.User;
import com.yamanin.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId);
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public boolean writeUser(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean modifyUser(User user) {
        if (userRepository.existsById(user.getUserId())) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeUser(int userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
