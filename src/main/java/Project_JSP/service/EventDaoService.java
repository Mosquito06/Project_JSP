package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.EventDao;
import Project_JSP.dto.Event;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class EventDaoService implements EventDao {
	private static final EventDaoService INSTANCE = new EventDaoService();

	public static EventDaoService getInstance() {
		return INSTANCE;
	}

	private EventDaoService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Event> selectEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			return dao.selectEvent();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Event selectEventByNum(Event event) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			return dao.selectEventByNum(event);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insertEvent(Event event) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			dao.insertEvent(event);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateEvent(Event event) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			dao.updateEvent(event);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEvent(Event event) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			dao.deleteEvent(event);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
