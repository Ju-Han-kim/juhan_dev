package com.juhan.web.user.repository;

import java.util.List;

import com.juhan.web.user.model.UserVO;

public interface IUserMapper {
	
	//회원가입
	void register(UserVO user);
	
	//회원 개인정보 조회
	UserVO selectOne(int userNo);
	
	//회원탈퇴
	void deleteUser(int userNo);
	
	//아이디 중복 확인
	int idCheck(String userId);
	
	//회원 전체 조회
	List<UserVO> getUsers();
}
