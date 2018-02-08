package Project_JSP.service;

import java.util.HashMap;
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

	@Override
	public List<Board> selcetAllLimitBoard(HashMap<String, Object> map) {
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BoardDao dao = session.getMapper(BoardDao.class);
			
			return dao.selcetAllLimitBoard(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
	public List<Board> findByTitleBoard(Board board) {
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BoardDao dao = session.getMapper(BoardDao.class);
			
			return dao.findByTitleBoard(board);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	

	@Override
	public List<Board> findByNameLimitBoard(HashMap<String, Object> map) {
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BoardDao dao = session.getMapper(BoardDao.class);
			
			return dao.findByNameLimitBoard(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Board> findByTitleLimitBoard(HashMap<String, Object> map) {
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BoardDao dao = session.getMapper(BoardDao.class);
			
			return dao.findByTitleLimitBoard(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}




	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void deletByNumBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	

	

}
