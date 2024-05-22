package com.yamanin.model.service;

import com.yamanin.model.dto.Profile;

public interface ProfileService {
    Profile getProfileById(int userId);
    int insert(Profile profile);
    int update(Profile profile);
    int delete(int userId);
}
