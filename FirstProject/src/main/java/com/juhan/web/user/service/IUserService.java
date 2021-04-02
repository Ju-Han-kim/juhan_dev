package com.juhan.web.user.service;

import java.util.List;

import com.juhan.web.user.model.UserVO;

public interface IUserService {
	
	//회원가입
	void register(UserVO user);
	
	//회원 개인정보 조회
	UserVO selectOne(String userId);
	
	//회원탈퇴
	void deleteUser(String userId);
	
	//아이디 중복 확인
	int idCheck(String userId);
	
	//회원 전체 조회
	List<UserVO> getUsers();
	
}
