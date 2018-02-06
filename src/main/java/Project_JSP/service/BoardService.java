package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.BoardDao;
import Project_JSP.dto.Board;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class BoardService {
	private static final BoardService instance = new BoardService();

	private BoardService() {
	}

	public static BoardService getInstance() {
		return instance;
	}

	public int insertBoard(Board board) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			BoardDao dao = session.getMapper(BoardDao.class);
			dao.insertBoard(board);
			session.commit();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
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
	
	public int updateBoard(Board board){
		SqlSession session = MySqlSessionFactory.openSession();
		try{
			BoardDao dao = session.getMapper(BoardDao.class);

			dao.updateBoard(board);
			session.commit();
			return 0;
		}catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			return -1;
		}finally {
			session.close();
		}
		
	}
	
	public int deletByNumBoard(Board board){
		SqlSession session = MySqlSessionFactory.openSession();
		try{
			BoardDao dao = session.getMapper(BoardDao.class);

			dao.deletByNumBoard(board);
			session.commit();
			return 0;
		}catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			return -1;
		}finally {
			session.close();
		}
	};
}
