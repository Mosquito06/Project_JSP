package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.BoardDao;
import Project_JSP.dto.Board;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class BoardService implements BoardDao{
	private static final BoardService instance = new BoardService();

	private BoardService() {
	}

	public static BoardService getInstance() {
		return instance;
	}


	
	public Board findByNumBoard(Board board){
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BoardDao dao = session.getMapper(BoardDao.class);
			
			return dao.findByNumBoard(board);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	};
	
	public List<Board> selcetAllBoard(){
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BoardDao dao = session.getMapper(BoardDao.class);
			
			return dao.selcetAllBoard();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	};
	
	


	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Board> findByNameBoard(Board board) {
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BoardDao dao = session.getMapper(BoardDao.class);
			
			return dao.findByNameBoard(board);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deletByNumBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		
	};
}
