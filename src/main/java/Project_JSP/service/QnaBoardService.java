package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.QnaBoardDao;
import Project_JSP.dto.QnaBoard;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class QnaBoardService implements QnaBoardDao{
	private static final QnaBoardService instance = new QnaBoardService();
	
	
	public static QnaBoardService getInstance() {
		return instance;
	}

	private QnaBoardService() {
		super();
	}

	@Override
	public void insertQnaBoard(QnaBoard qnaBoard) {
		
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			QnaBoardDao dao = session.getMapper(QnaBoardDao.class);
			dao.insertQnaBoard(qnaBoard);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<QnaBoard> selectAllQnaBoard() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			QnaBoardDao dao = session.getMapper(QnaBoardDao.class);
			return dao.selectAllQnaBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}

	@Override
	public QnaBoard selectByNumQnaBoard(QnaBoard qnaBoard) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			QnaBoardDao dao = session.getMapper(QnaBoardDao.class);
			return dao.selectByNumQnaBoard(qnaBoard);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void deleteByNumQnaBoard(QnaBoard qnaBoard) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			QnaBoardDao dao = session.getMapper(QnaBoardDao.class);
			dao.deleteByNumQnaBoard(qnaBoard);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int lastId() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			QnaBoardDao dao = session.getMapper(QnaBoardDao.class);
			return dao.lastId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<QnaBoard> selectAllQnaBoardById(QnaBoard qnaBoard) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			QnaBoardDao dao = session.getMapper(QnaBoardDao.class);
			return dao.selectAllQnaBoardById(qnaBoard);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}



}
