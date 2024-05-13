package com.yamanin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamanin.model.dto.Profile;
import com.yamanin.model.service.ProfileService;

import java.util.Optional;

@RestController
@RequestMapping("/api-profiles")
public class ProfileController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Profile> getProfileById(@PathVariable int userId) {
        Profile profile = profileService.getProfileById(userId);
        return profile != null ? ResponseEntity.ok(profile) : ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<String> createProfile(@RequestBody Profile profile) {
        int result = profileService.insert(profile);
        if (result == 1) {
            return ResponseEntity.ok("Profile created successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to create profile.");
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateProfile(@PathVariable int userId, @RequestBody Profile profile) {
        profile.setUserId(userId); // Assuming Profile has a setUserId method
        int result = profileService.update(profile);
        if (result == 1) {
            return ResponseEntity.ok("Profile updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to update profile.");
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteProfile(@PathVariable int userId) {
        int result = profileService.delete(userId);
        if (result == 1) {
            return ResponseEntity.ok("Profile deleted successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete profile.");
        }
    }
}