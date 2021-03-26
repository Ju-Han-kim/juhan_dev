package com.juhan.web.freeBoard;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juhan.web.commons.PageVO;
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
	
	//show one article unit test
	@Test
	public void getArticle() {
		System.out.println(mapper.getArticle(1));
	}
	
	//insert article unit test
	@Test
	public void insertArticle() {
		FreeBoardVO article = new FreeBoardVO();
		
		for(int i=1; i<140; i++) {
			article.setTitle("테스트제목" + i);
			article.setWriter("테스트작성자" + i);
			article.setContent("테스트내용" + i);
			mapper.insertArticle(article);
		}
	}
	

	//update article unit test
	@Test
	public void updateArticle() {
		
		FreeBoardVO article = new FreeBoardVO();
		
		article.setBoardNo(1);
		article.setTitle("수정테스트제목");
		article.setContent("수정테스트내용");
		
		mapper.updateArticle(article);
		
	}
	
	//delete article unit test
	@Test
	public void deleteArticle() {
		mapper.deleteArticle(1);
	}
	
	
	//count all articles
	@Test
	public void count() {
		System.out.println("총 게시물 수 :" + mapper.countArticles());
	}
	
	//paging
	
	//getArticles[begin ~ end]
	@Test
	public void message() {
		PageVO paging = new PageVO();
		
		paging.setMessagePerPage(5);
		
		List<FreeBoardVO> list = mapper.getArticleList(paging); 
		for(FreeBoardVO article : list) {
			System.out.println(article);
		}
	}
	
	
	
	
	
	
	
	
}




