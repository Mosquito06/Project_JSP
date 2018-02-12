package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.BoardDao;
import Project_JSP.dao.CommentDao;
import Project_JSP.dto.Comment;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class CommentService {
	private static final CommentService instance = new CommentService();

	private CommentService() {
	}

	public static CommentService getInstance() {
		return instance;
	}

	public List<Comment> selcetAllComment() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			CommentDao dao = session.getMapper(CommentDao.class);

			return dao.selcetAllComment();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	};

	public List<Comment> findByNumComment(Comment comment) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			CommentDao dao = session.getMapper(CommentDao.class);

			return dao.findByNumComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int insertComment(Comment comment) {
		SqlSession session = MySqlSessionFactory.openSession();
		try {
			CommentDao dao = session.getMapper(CommentDao.class);
			int result = dao.insertComment(comment);
			if (result <= 0) {
				return -1;
			}
			session.commit();
			return result;
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return -1;
	}

	public int deleteComment(Comment comment) {
		SqlSession session = MySqlSessionFactory.openSession();
		try {
			CommentDao dao = session.getMapper(CommentDao.class);
			int result = dao.deletByNumComment(comment);
			if (result <= 0) {
				return -1;
			}
			session.commit();
			return result;
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return -1;
	}
	
	public int updateComment(Comment comment) {
		SqlSession session = MySqlSessionFactory.openSession();
		try {
			CommentDao dao = session.getMapper(CommentDao.class);
			int result = dao.updateComment(comment);
			if (result <= 0) {
				return -1;
			}
			session.commit();
			return result;
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return -1;
	}

	

}
