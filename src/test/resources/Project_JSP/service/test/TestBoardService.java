package Project_JSP.service.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import Project_JSP.dto.Board;
import Project_JSP.service.BoardService;

public class TestBoardService {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/*@Test
	public void testDeleteBoard() {
		BoardService serivce = BoardService.getInstance();
		Board board = new Board();
		board.setNum(2);
		
		serivce.deletByNumBoard(board);
	}
	
	@Test
	public void testInertBoard() {
		BoardService serivce = BoardService.getInstance();
		Board board = new Board();
		board.setNum(0);
		board.setTitle("제목");
		board.setName("테스터");
		board.setEmail("email@test.com");
		board.setTel("010-123-1234");
		board.setType(0);
		
		serivce.insertBoard(board);
	}*/
	
	@Test
	public void testSelectAll() {
		BoardService serivce = BoardService.getInstance();
		
		List<Board> list =  serivce.selcetAllBoard();
		System.out.println(list);
		Assert.assertNotNull(list);
	}
	@Test
	public void testUpdateBoard() {
		BoardService serivce = BoardService.getInstance();
		Board board = new Board();
		board.setNum(3);
		board.setTitle("수정");
		board.setName("테스터22");
		board.setEmail("emai22l@test.com");
		board.setTel("010-123-221234");
		board.setType(1);
		
		int res = serivce.updateBoard(board);
		System.out.println(res);
	}
	
	@Test
	public void testFindByNum() {
		BoardService serivce = BoardService.getInstance();
		Board board = new Board();
		board.setNum(3);
		Board board2 = serivce.findByNumBoard(board);
		System.out.println(board2);
		Assert.assertEquals(board.getNum(), board2.getNum());
	}
	
	
	

}
