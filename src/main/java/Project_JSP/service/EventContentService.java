package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.EventContentDao;
import Project_JSP.dto.EventContent;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class EventContentService {
	private static final EventContentService INSTANCE = new EventContentService();

	public static EventContentService getInstance() {
		return INSTANCE;
	}

	private EventContentService() {}

	public List<EventContent> selectEventContent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			return dao.selectEventContent();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public EventContent selectEventContentByNum(EventContent eventContent) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			return dao.selectEventContentByNum(eventContent);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int insertEventContent(EventContent eventContent) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			dao.insertEventContent(eventContent);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	public void updateEventContent(EventContent eventContent) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			dao.updateEventContent(eventContent);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteEventContent(EventContent eventContent) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			dao.deleteEventContent(eventContent);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
