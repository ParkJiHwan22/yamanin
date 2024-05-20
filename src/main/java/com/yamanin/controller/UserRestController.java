package com.yamanin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yamanin.model.dto.User;
import com.yamanin.model.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/user")
@Tag(name = "UserRestController", description = "유저 CRUD")
@CrossOrigin(origins = "http://localhost:5173")
public class UserRestController {
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String loginId, @RequestParam String password) {
        logger.info("Login attempt with loginId: {}", loginId);

        Optional<User> userOpt = userService.findByLoginId(loginId);
        logger.info("User found: {}", userOpt);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(password)) {
                logger.info("Login successful for user: {}", loginId);
                return ResponseEntity.ok("Login successful");
            } else {
                logger.warn("Login failed: Incorrect password for user: {}", loginId);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: Incorrect password");
            }
        } else {
            logger.warn("Login failed: User not found for loginId: {}", loginId);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: User not found");
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping("/adduser")
    public ResponseEntity<User> write(@RequestBody User user) {
        userService.writeUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/modifyuser")
    public ResponseEntity<String> update(@RequestBody User user) {
        if (userService.modifyUser(user)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable("userId") int id) {
        if (userService.removeUser(id)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.NOT_FOUND);
    }
}
