package com.juhan.web.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.juhan.web.user.model.UserVO;
import com.juhan.web.user.repository.IUserMapper;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserMapper mapper;
	
	@Override
	public void register(UserVO user) {
		BCryptPasswordEncoder encoding = new BCryptPasswordEncoder();
		user.setPassword(encoding.encode(user.getPassword()));
		mapper.register(user);
	}

	@Override
	public UserVO selectOne(String userId) {
		return mapper.selectOne(userId);
	}

	@Override
	public void deleteUser(String userId) {
		mapper.deleteUser(userId);
	}

	@Override
	public int idCheck(String userId) {
		return mapper.idCheck(userId);
	}

	@Override
	public List<UserVO> getUsers() {
		return mapper.getUsers();
	}
	
	@Override
	public void setAutoLogin(String userId, String sessionId, Date limitDate) {
		Map<String , Object> datas = new HashMap<String, Object>();
		
		datas.put("userId", userId);
		datas.put("sessionId", sessionId);
		datas.put("limitDate", limitDate);
		
		mapper.setAutoLogin(datas);
	}

	@Override
	public UserVO selectOneWithSessionId(String sessionId) {
		return mapper.selectOneWithSessionId(sessionId);
	}
	
	@Override
	public void logout(String userId) {
		mapper.logout(userId);
	}
	
}
