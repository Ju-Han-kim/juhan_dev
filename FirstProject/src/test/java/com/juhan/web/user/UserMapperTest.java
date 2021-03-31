package com.juhan.web.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juhan.web.user.model.UserVO;
import com.juhan.web.user.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserMapperTest {

	@Autowired
	private IUserMapper mapper;
	
	@Test
	public void registerTest() {
		UserVO user = new UserVO();
		
		user.setUserId("asd1234");
		user.setPassword("asd1234!");
		user.setName("홍길동");
		
		mapper.register(user);
		
	}
	
	@Test
	public void selectOneTest() {
		int userNo = 1;
		UserVO user = mapper.selectOne(userNo);
		System.out.println(user);
	}
	
	@Test
	public void deleteUserTest() {
		mapper.deleteUser(1);
	}
	
	@Test
	public void idCheckTest() {
		System.out.println(mapper.idCheck("asd12345"));
	}
	
	@Test
	public void getUsersTest() {
		List<UserVO> list = mapper.getUsers();
		
		System.out.println("===================");
		for(UserVO user : list) {
			System.out.println(user);
		}
		System.out.println("===================");
	}
	
	
	
	
	
	
	
	
	
	
}























