package com.yamanin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamanin.model.dao.ProfileDao;
import com.yamanin.model.dto.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	private final ProfileDao profileDao;
	
	@Autowired
	public ProfileServiceImpl(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}
	
	@Override
	public Profile getProfileById(int userId) {
		return profileDao.selectOne(userId);
	}


	@Override
	public int insert(Profile profile) {
		return profileDao.insertProfile(profile);
	}

	@Override
	public int update(Profile profile) {
		return profileDao.updateProfile(profile);
	}

	@Override
	public int delete(int userId) {
		return profileDao.deleteProfile(userId);
	}
	
}
