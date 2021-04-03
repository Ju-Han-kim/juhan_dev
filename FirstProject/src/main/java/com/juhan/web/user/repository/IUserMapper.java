package com.juhan.web.user.repository;

import java.util.List;
import java.util.Map;

import com.juhan.web.user.model.UserVO;

public interface IUserMapper {
	
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
	
	//자동로그인 세션ID, 만료기간 설정
	void setAutoLogin(Map<String, Object> datas);
	
	//세션ID로 회원정보 받아오기
	UserVO selectOneWithSessionId(String sessionId);
	
}
