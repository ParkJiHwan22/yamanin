package com.yamanin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamanin.model.dao.RecommentDao;
import com.yamanin.model.dto.Recomment;


@Service
public class RecommentServiceImpl implements RecommentService{

	private final RecommentDao recommentDao;
	
	@Autowired
	public RecommentServiceImpl(RecommentDao recommentDao) {
		this.recommentDao = recommentDao;
	}
	
	@Override
	public List<Recomment> getAllRecomment() {
		return recommentDao.selectAll();
	}

	@Override
	public Recomment getRecommentByRecommentId(int recommentId) {
		return recommentDao.selectById(recommentId);
	}

	@Override
	public int insert(Recomment recomment) {
		return recommentDao.insertRecomment(recomment);
	}

	@Override
	public int delete(int recommentId) {
		return recommentDao.deleteRecomment(recommentId);
	}

}
