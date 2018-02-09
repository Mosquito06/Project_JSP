package Project_JSP.service.test;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import Project_JSP.dto.BoardContent;
import Project_JSP.service.BoardContentService;

public class TestBoardContentService {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/*@Test
	public void testDeleteBoard() {
		BoardContentService serivce = BoardContentService.getInstance();
		
		
		serivce.deletByNum(3);
	}*/
	
	/*@Test
	public void testInertBoard() {
		BoardContentService serivce = BoardContentService.getInstance();
		
		BoardContent content = new BoardContent();
		content.setNum(3);
		content.setContent("테스트으으으");
		serivce.insert(content);
		
	}*/
	
	/*
	@Test
	public void testUpdateBoard() {
		BoardContentService serivce = BoardContentService.getInstance();
		
		BoardContent content = new BoardContent();
		content.setNum(3);
		content.setContent("asdfasdfasd");
		
		int res = serivce.update(content);
		System.out.println(res);
	}
	
	@Test
	public void testFindByNum() {
		BoardContentService serivce = BoardContentService.getInstance();
		BoardContent content = serivce.findByNum(3);
		Assert.assertNotNull(content);
		System.out.println(content);
	}*/
}
