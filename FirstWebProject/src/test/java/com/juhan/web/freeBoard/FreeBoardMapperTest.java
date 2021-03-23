package com.juhan.web.freeBoard;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juhan.web.freeBoard.model.FreeBoardVO;
import com.juhan.web.freeBoard.repository.IFreeBoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class FreeBoardMapperTest {
	
	@Autowired
	private IFreeBoardMapper mapper;
	
	//show all articles unit test
	@Test
	public void getArticleList() {
		List<FreeBoardVO> list = mapper.getArticleList();
		
		System.out.println(list);
		
		for(FreeBoardVO article : list) {
			System.out.println(article);
		}
	}

	
	
	
	
	
	
	
	
	
	
}




