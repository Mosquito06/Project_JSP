package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.QnaReplyDao;
import Project_JSP.dto.QnaReply;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class QnaReplyService implements QnaReplyDao {
	private static final QnaReplyService instance = new QnaReplyService();
	
	private QnaReplyService() {}
	
	public static QnaReplyService getInstance() {
		return instance;
	}

	@Override
	public List<QnaReply> selectAllQnaReply() {
		try(SqlSession session = MySqlSessionFactory.openSession()){
			QnaReplyDao dao = session.getMapper(QnaReplyDao.class);
			return dao.selectAllQnaReply();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public QnaReply findByNumQnaReply(QnaReply qnaReply) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			QnaReplyDao dao = session.getMapper(QnaReplyDao.class);
			return dao.findByNumQnaReply(qnaReply);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insertQnaReply(QnaReply qnaReply) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			QnaReplyDao dao = session.getMapper(QnaReplyDao.class);
			dao.insertQnaReply(qnaReply);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteByNumQnaReply(QnaReply qnaReply) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			QnaReplyDao dao = session.getMapper(QnaReplyDao.class);
			dao.deleteByNumQnaReply(qnaReply);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateReply(QnaReply qnaReply) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			QnaReplyDao dao = session.getMapper(QnaReplyDao.class);
			dao.updateReply(qnaReply);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public QnaReply selectQnaReplyByNum(QnaReply qnaReply) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			QnaReplyDao dao = session.getMapper(QnaReplyDao.class);
			return dao.selectQnaReplyByNum(qnaReply);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void deleteQnaReplyByQnaNum(QnaReply qnaReply) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			QnaReplyDao dao = session.getMapper(QnaReplyDao.class);
			dao.deleteQnaReplyByQnaNum(qnaReply);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
