package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.EventContentDao;
import Project_JSP.dto.EventContent;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class EventContentService implements EventContentDao {
	private static final EventContentService INSTANCE = new EventContentService();

	public static EventContentService getInstance() {
		return INSTANCE;
	}

	private EventContentService() {}

	@Override
	public List<EventContent> selectEventContent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			return dao.selectEventContent();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public EventContent selectEventContentByNum(EventContent eventContent) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			return dao.selectEventContentByNum(eventContent);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
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

	@Override
	public void updateEventContent(EventContent eventContent) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			dao.updateEventContent(eventContent);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
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
