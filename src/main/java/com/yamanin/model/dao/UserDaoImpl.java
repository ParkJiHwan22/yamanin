package com.yamanin.model.dao;

import org.springframework.stereotype.Repository;
import com.yamanin.model.dto.User;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public int insertUser(User user) {
        // 데이터베이스 로직 구현
        return 1; // 임시 반환 값
    }

    @Override
    public int updateUser(User user) {
        // 데이터베이스 로직 구현
        return 1; // 임시 반환 값
    }

    @Override
    public int deleteUser(int id) {
        // 데이터베이스 로직 구현
        return 1; // 임시 반환 값
    }
}