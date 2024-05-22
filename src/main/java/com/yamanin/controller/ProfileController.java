package com.yamanin.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.yamanin.model.dto.Profile;
import com.yamanin.model.dto.ProfileDto;
import com.yamanin.model.service.ProfileService;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadProfile(
            @RequestParam("userId") int userId,
            @RequestParam("file") MultipartFile file,
            @RequestParam("profileText") String profileText,
            @RequestParam("supportTeam") String supportTeam) throws IOException {
        Profile profile = new Profile();
        profile.setUserId(userId);
        profile.setProfileImg(file.getBytes());
        profile.setProfileText(profileText);
        profile.setSupportTeam(supportTeam);
        profileService.insert(profile);
        return ResponseEntity.ok("Profile uploaded successfully");
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateProfile(
            @PathVariable int userId,
            @RequestParam("file") MultipartFile file,
            @RequestParam("profileText") String profileText,
            @RequestParam("supportTeam") String supportTeam) throws IOException {
        Profile profile = profileService.getProfileById(userId);
        if (profile != null) {
            profile.setProfileImg(file.getBytes());
            profile.setProfileText(profileText);
            profile.setSupportTeam(supportTeam);
            profileService.update(profile);
            return ResponseEntity.ok("Profile updated successfully");
        } else {
            return ResponseEntity.status(404).body("Profile not found");
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ProfileDto> getProfile(@PathVariable int userId) {
        Profile profile = profileService.getProfileById(userId);
        ProfileDto profileDto = new ProfileDto();
        profileDto.setUserId(profile.getUserId());
        profileDto.setProfileImg(Base64.getEncoder().encodeToString(profile.getProfileImg()));
        profileDto.setProfileText(profile.getProfileText());
        profileDto.setSupportTeam(profile.getSupportTeam());
        return ResponseEntity.ok(profileDto);
    }
}
