package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.EventContentDao;
import Project_JSP.dao.EventDao;
import Project_JSP.dto.Event;
import Project_JSP.dto.EventContent;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class EventService  {
	private static final EventService INSTANCE = new EventService();
	private static final String log = "[EventService]";
	
	public static EventService getInstance() {
		return INSTANCE;
	}

	private EventService() {}

	public List<Event> selectListEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			
			return dao.selectEvent();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Event readEventByNum(Event event) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			return dao.selectEventByNum(event);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int insertEvent(Event event, String content) {
		SqlSession session = MySqlSessionFactory.openSession();
		
		try {
			EventDao dao = session.getMapper(EventDao.class);
			EventContentDao contentDao = session.getMapper(EventContentDao.class);
			
			dao.insertEvent(event);
			System.out.println("insertEvent");
			int newEventId = dao.selectLastInsert();	
			System.out.println(newEventId);
			
			if(newEventId < 0){
				System.out.println(log + "insert event fail");
				return -2;
			}
			
			EventContent eventContent = new EventContent(newEventId, content);
			
			int successContent = contentDao.insertEventContent(eventContent);
			System.out.println(successContent);
			
			if(successContent <0){
				System.out.println(log + "insert eventContent fail");
				return -3;
			}
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return 1;
	}

	public void updateEvent(Event event) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			dao.updateEvent(event);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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
