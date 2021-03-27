package com.juhan.web.freeBoard;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juhan.web.freeBoard.model.FreeBoardCommentVO;
import com.juhan.web.freeBoard.repository.IFreeBoardCommentMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class FreeBoardCommentMapperTest {

	@Autowired
	private IFreeBoardCommentMapper mapper;
	
	//게시글 별 댓글 가져오기
	@Test
	public void getAllCommentsTest() {
		List<FreeBoardCommentVO> list =  mapper.getComments(3);
		for(FreeBoardCommentVO comment: list) {
			System.out.println(comment);
		}
	}
	
	//댓글 삭제
	@Test
	public void deleteCommentTest() {
		mapper.deleteComment(2);
	}
	
	//댓글 수정
	@Test
	public void updateCommentTest() {
		FreeBoardCommentVO comment = new FreeBoardCommentVO();
		
		comment.setCommentNo(8);
		comment.setContent("수정내용입니다.");
		
		mapper.updateCommentTest(comment);
		
	}
	
	//댓글 작성
	@Test
	public void insertCommentTest() {
		FreeBoardCommentVO comment = new FreeBoardCommentVO();
		
		comment.setBoardNo(3);
		comment.setWriter("작성자 삽입테스트");
		comment.setContent("내용 삽입테스트");
		
		mapper.insertComment(comment);
	}
	
	
}












