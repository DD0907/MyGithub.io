package com.entranceGuard.service;

import java.util.List;

import com.entranceGuard.pojo.TLogin;

public interface UserService {
	int insertUser(TLogin tLogin);

	int updateUser(TLogin tLogin);

	int deleteUser(TLogin tLogin);

	TLogin selectUserByUsername(String username);

	List<TLogin> selectUserAll();

	List<TLogin> selectUserByUsernames(String username);
}
