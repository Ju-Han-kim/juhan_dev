package com.juhan.web.user.service;

import java.util.List;

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

}
