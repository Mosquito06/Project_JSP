package Project_JSP.service;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.BoardContentDao;
import Project_JSP.dto.BoardContent;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class BoardContentService {
	private static final BoardContentService instance = new BoardContentService();
	
	public static BoardContentService getInstance() {
		return instance;
	}
	
	private BoardContentService() {}

	public int insert(BoardContent content){
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			BoardContentDao dao = session.getMapper(BoardContentDao.class);
			dao.insert(content);
			session.commit();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;		
	};
	public BoardContent findByNum(int boardNum){
		try(SqlSession session = MySqlSessionFactory.openSession()){
			BoardContentDao dao = session.getMapper(BoardContentDao.class);
			
			return dao.findByNum(boardNum);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	};
	public int deletByNum(int boardNum){
		SqlSession session = MySqlSessionFactory.openSession();
		try{
			BoardContentDao dao = session.getMapper(BoardContentDao.class);

			dao.deletByNum(boardNum);
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
	public int update(BoardContent content){
		SqlSession session = MySqlSessionFactory.openSession();
		try{
			BoardContentDao dao = session.getMapper(BoardContentDao.class);

			dao.update(content);
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
